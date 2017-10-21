#include<stdio.h>
#include<string.h>
#include<math.h> //sqrt 
#include<stdlib.h> //srand
#define MAX 20

typedef struct Mgraph
{
	int vexs[MAX];  //顶点数组 
	float edge[MAX][MAX]; //邻接矩阵 
	int vexnum; //边数 
	int arcnum; //顶点数 
}Mgraph;

void ShortestPath_DIJ(Mgraph G,int v0,int P[G.vexnum][G.vexnum],float D[G.vexnum]);

int main()
{
	int i,j,k,x,y;
	int num1=0,num2=0,num; 
	int xlab[20],ylab[20],r[3];
	char exam[500],no[20];
	Mgraph GRAPH;
	FILE *fexam1=fopen("2150504006_3.txt","r");
	FILE *fexam2=fopen("2150504006_4.txt","r");
	FILE *fm1=fopen("mousedown_3.txt","w"); 
	FILE *fm2=fopen("mousedown_4.txt","w"); 
	if (!fexam1||!fexam2)
	{
		printf("FAIL TO READ!");
		exit(0);
	}
	while(!feof(fexam1))
	{
		fgets(exam,500,fexam1);
		if(strncmp(exam,"HDHorizontal mousedown",22)==0)
		{
			fputs(exam,fm1);
			num1=num1+1;
		}
	}
	while(!feof(fexam2))
	{
		fgets(exam,500,fexam2);
		if(strncmp(exam,"HDHorizontal mousedown",22)==0)
		{
			fputs(exam,fm2);
			num2=num2+1;
		}
	}
	num=num1+num2;
	fclose(fexam1);
	fclose(fexam2);
	fclose(fm1);
	fclose(fm2);
	FILE *FM1=fopen("mousedown_3.txt","r"); 
	FILE *FM2=fopen("mousedown_4.txt","r"); 
	for(i=0;i<num;i++)
	{
		GRAPH.vexs[i]=i;
	}
	GRAPH.vexnum=num;
	int P[GRAPH.vexnum][GRAPH.vexnum];
	float D[GRAPH.vexnum];
	for(i=0;i<num1;i++)
	{
		fscanf(FM1,"%s %s %d %d %s",&no,&no,&xlab[i],&ylab[i],&no);
	}
	for(;i<num;i++)
	{
		fscanf(FM2,"%s %s %d %d %s",&no,&no,&xlab[i],&ylab[i],&no);
	}
	for(i=0;i<num;i++)
	{
		for(j=0;j<num;j++)
		{
			GRAPH.edge[i][j]=1000000;
			GRAPH.edge[i][i]=0;
		}
	}
	for(i=0;i<num-1;i++)
	{
		GRAPH.edge[i][i+1]=sqrt((xlab[i+1]-xlab[i])*(xlab[i+1]-xlab[i])+(ylab[i+1]-ylab[i])*(ylab[i+1]-ylab[i]));
		GRAPH.edge[i+1][i]=GRAPH.edge[i][i+1];
	}
	GRAPH.edge[num1-1][num1]=1000000;
	GRAPH.edge[num1][num1-1]=1000000;
	GRAPH.arcnum=num-2; 
	for(i=0;i<3;i++)
	{
		srand(i);
		r[i]=rand()%(num1*num2);
		x=(r[i]-r[i]%5)/5;
		y=r[i]%5+4;
		GRAPH.edge[x][y]=sqrt((xlab[x]-xlab[y])*(xlab[x]-xlab[y])+(ylab[x]-ylab[y])*(ylab[x]-ylab[y]));
		GRAPH.edge[y][x]=GRAPH.edge[x][y];
	}
	/*for(i=0;i<GRAPH.vexnum;i++)
	{
		for(j=0;j<GRAPH.vexnum;j++)
		{
			printf("%8.2f\t",GRAPH.edge[i][j]);
		}
		printf("\n");
	}*/
	//for(k=0;k<num;k++)
	//{	
		ShortestPath_DIJ(GRAPH,0,P,D);
		printf("**************以第1个点为起点**************\n");
		for(i=0;i<GRAPH.vexnum;i++)
		{
			printf("\n以第%d个点为终点所经过的点有\t",i+1);
			for(j=0;j<GRAPH.vexnum;j++)
			{
				if(P[i][j])
					printf("%d ",j+1);
			}
			printf("\n\t\t长度为%.2f\n",D[i]);
		}
		printf("\n");
	//}
	return 0;
}

void ShortestPath_DIJ(Mgraph G,int v0,int P[G.vexnum][G.vexnum],float D[G.vexnum])
{
	int v,w,i,min,k;
	int final[G.vexnum]; //标记是否求得最短路径 
	for(v=0;v<G.vexnum;v++)
	{
		final[v]=0;
		D[v]=G.edge[v0][v];
		for(w=0;w<G.vexnum;++w) P[v][w]=0;  //设空路径 
		if(D[v]<1000000)
		{
			P[v][v0]=1; //图中存在从v到v0的边 
			P[v][v]=1;
		}
	}
	D[v0] =0;
	final[v0]=1;  //初始化，vo属于s集 
	for(i=0;i<G.vexnum;i++)
	{
		min=1000000;
		for(w=0;w<G.vexnum;++w)
		{
			if(!final[w])  //w顶点在V-S中 
				if(D[w]<min) //w顶点离v0更近 
				{
					v=w;
					min=D[w];
				}
		}
		final[v]=1; //最近的v加入s集 
		for(w=0;w<G.vexnum;w++)  //更新当前最短路径及距离 
		{
			if(!final[w]&&(min+G.edge[v][w]<D[w]))
			{
				D[w]=min+G.edge[v][w];
				for(k=0;k<G.vexnum;k++)
				{
					P[w][k]=P[v][k];
				}
				P[w][w]=1;
			}
			//P[w][w]=1;
		}
	}
}
