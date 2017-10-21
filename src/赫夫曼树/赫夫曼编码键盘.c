#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct
{
	unsigned int weight;
	unsigned int parent,lchild,rchild;
} HTNode,*HuffmanTree;  //动态分配数组给赫夫曼树 
typedef char **HuffmanCode;  //动态分配数组存储赫夫曼表 

void HuffmanCoding(HuffmanTree *HT,HuffmanCode *HC,int *w,int n);
void Select(HuffmanTree HT,int i,int *s1,int *s2);

void HuffmanCoding(HuffmanTree *HT,HuffmanCode *HC,int *w,int n)
{
	int m=2*n-1;
	int i,s1,s2,start,c,f;
	if(n<=1)
		exit(0);
	HuffmanTree p;
	*HT=(HuffmanTree)malloc((m+1)*sizeof(HTNode));   //0号单元未用 
	for(p=*HT,p++,i=1;i<=n;++i,++p,++w)
	{
		(*p).weight=*w;
		(*p).parent=0;
		(*p).lchild=0;
		(*p).rchild=0;
	}
	for(;i<=m;++i,++p)
	{
		(*p).weight=0;
		(*p).parent=0;
		(*p).lchild=0;
		(*p).rchild=0;
	}
	for(i=n+1;i<=m;++i)  //构建赫夫曼树 
	{
		Select(*HT,i-1,&s1,&s2);
		(*HT)[s1].parent=i;
		(*HT)[s2].parent=i;
		(*HT)[i].lchild=s1;
		(*HT)[i].rchild=s2;
		(*HT)[i].weight=(*HT)[s1].weight+(*HT)[s2].weight;
	}
	*HC=(HuffmanCode)malloc((n+1)*sizeof(char*));  //分配n个编码的头指针向量
	char *cd=(char*)malloc(n*sizeof(char*));
	cd[n-1]='\0';
	for(i=1;i<=n;++i)
	{
		start=n-1;
		for(c=i,f=(*HT)[i].parent;f!=0;c=f,f=(*HT)[f].parent)
		{
			if((*HT)[f].lchild==c)
				cd[--start]='0';
			else if((*HT)[f].rchild==c)
				cd[--start]='1';
		}
		(*HC)[i]=(char*)malloc((n-start)*sizeof(char));
		strcpy((*HC)[i],&cd[start]);
	}
	free(cd);
}

void Select(HuffmanTree HT,int num,int *s1,int *s2)
{
	int i,temp;
	for(i=1;i<=num;i++)
	{
		if(HT[i].parent==0)
		{
			temp=HT[i].weight;
			*s1=i;
			break;
		}
	}
	if(i==num+1) return;
	for(;i<=num;i++)
	{
		if(HT[i].weight<temp&&HT[i].parent==0)
		{
			temp=HT[i].weight;
			*s1=i;
		}
	}
	
	for(i=1;i<=num;i++)
	{
		if(HT[i].parent==0&&i!=*s1)
		{
			temp=HT[i].weight;
			*s2=i;
			break;
		}
	}
	if(i==num+1) return;
	for(;i<=num;i++)
	{
		if(HT[i].weight<temp&&HT[i].parent==0&&i!=*s1)
		{
			temp=HT[i].weight;
			*s2=i;
		}
	}
	
}


int main()
{
	int num = 0,i,j,k;
	char exam[500],no[20];
	HuffmanTree HT;
	HuffmanCode HC;
	FILE *fexam=fopen("2150504006_1.txt","r");
	FILE *fkey=fopen("key.txt","w"); 
	if (!fexam)
	{
		printf("FAIL TO READ!");
		exit(0);
	}
	while(!feof(fexam))
	{
		fgets(exam,500,fexam);
		if(!(strncmp(exam,"login keydown",17)==0))
		{
			fputs(exam,fkey);
			num=num+1;
		}
	}
	fclose(fexam);
	fclose(fkey);
	
	int weight[num];
	int key[num];
	FILE *Fkey=fopen("key.txt","r"); 
	for(i=0;i<num;i++)
	{
		fscanf(Fkey,"%s %s %d %s",&no,&no,&key[i],&no);
	}
	fclose(Fkey);
	for(i=0;i<num;i++)
	{
		weight[i]=1;
	}
	for(i=0;i<num;i++)
	{
		for(j=i+1;j<num;j++)
		{
			if(key[i]==key[j])
			{
				weight[i]=weight[i]+weight[j];
				for(k=j;k<num-1;k++)
				{
					key[k]=key[k+1];
					weight[k]=weight[k+1];
				}
				num=num-1;
				j=j-1;
			}
		}
	}  //计算权重，删除重复点 

	//printf("this is an interval") ;
	HuffmanCoding(&HT,&HC,weight,num);
	//printf("this is interval2") ;
	printf("权值\tASCII码\t\t赫夫曼编码\t键值\n");
	for(i=0;i<num;i++)
	{
		printf("%d\t%d\t\t%s\t\t%d\n",weight[i],key[i],HC[i+1],key[i]);
	}
	return(0);
}





