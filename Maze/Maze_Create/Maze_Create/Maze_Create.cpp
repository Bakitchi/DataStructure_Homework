#include "Maze_Create.h"
using namespace std;

Maze::Maze(int pRow, int pColumn)
{
	row = 2 * pRow + 1;
	column = 2 * pColumn + 1;
	UFSLength = pRow * pColumn;
	initMaze(pRow, pColumn, maze);
	initUnionFindSet(unionFindSet);

	makeMaze(maze);
	cout << "�Թ������ʼ�����" << endl;
}

Maze::~Maze()
{
	for (int i = 0; i < column; i++)
		delete[] maze[i];
	delete[] maze;
	maze = NULL;
	delete unionFindSet;
	unionFindSet = NULL;
}

void Maze::initMaze(int row, int column, char**& maze)
{
	int realRow = 2 * row + 1;
	int realColumn = 2 * column + 1;
	maze = new char*[realColumn];
	for (int i = 0; i < realColumn; i++)
	{
		maze[i] = new char[realRow];
	}

	//��ʼ��ԭʼ�Թ�����
	for (int i = 0; i < realColumn; i++)
	{
		for (int j = 0; j < realRow; j++)
		{
			if (i % 2 == 0 && j % 2 == 0)
			{
				maze[i][j] = wallCorner;
			}
			else if (i % 2 == 0 && j % 2 == 1)
			{
				maze[i][j] = wallSymbolH;
			}
			else if (i % 2 == 1 && j % 2 == 0)
			{
				maze[i][j] = wallSymbolV;
			}
			else
			{
				maze[i][j] = roomSymbol;
			}
		}
	}
	maze[0][1] = roomSymbol;
	maze[realColumn - 1][realRow - 2] = roomSymbol;
}

void Maze::initUnionFindSet(int*& unionFindSet)
{
	unionFindSet = new int[UFSLength];
	for (int i = 0; i < UFSLength; i++)
	{
		unionFindSet[i] = i;
	}

}

void Maze::makeMaze(char**& maze)
{
	srand((unsigned)time(0));
	while (!isJioned(mazeAdapter(1, 1), mazeAdapter(column - 2, row - 2)))//�����յ㲻��ͨ
	{
		int i = rand() % (column - 1);
		int j = rand() % (row - 1);
		if (i != 0 && i != column && j != 0 && j != row) // �Ǳ߽�ǽ
		{
			if ((i % 2 != 1 && j % 2 != 0))//������ǽ����"|"
			{
				//              cout<<"������ǽ����\"|\""<<endl;
				uionSet(mazeAdapter(i - 1, j), mazeAdapter(i + 1, j));
				maze[i][j] = roomSymbol;

			}
			else if ((i % 2 != 0 && j % 2 != 1))//������ǽ����"-"
			{
				//              cout<<"������ǽ����\"-\""<<endl;
				uionSet(mazeAdapter(i, j - 1), mazeAdapter(i, j + 1));
				maze[i][j] = roomSymbol;
			}
		}
	}
}

void Maze::solveMaze(char**& maze)
{
	reStore(maze);
	int i = 1;
	int j = 1;
	char step = '0';
	DFAlgorithm(maze, i, j, step);

	cout << endl;
}

void Maze::solveMazeSecond(char**& maze)
{
	reStore(maze);
	int i = 1;
	int j = 1;
	char step = resultSymbol;
	DFAlgorithmSecond(maze, i, j, step);
	maze[i][j] = step;
	maze[i - 1][j] = step;
	maze[column - 1][row - 2] = step;
	for (int i = 0; i < column; i++)
	{
		for (int j = 0; j < row; j++)
		{
			if ((i % 2 == 1 && j % 2 == 1) && maze[i][j] == '$')
			{
				maze[i][j] = roomSymbol;
			}
		}
	}

	cout << endl;
}

int Maze::DFAlgorithm(char**& maze, int i, int j, char& step)
{
	maze[i][j] = step;
	if (step == '9')
		step = '0';
	else
		step++;

	if ((i == column - 2) && (j == row - 2))
		return 1;
	else
	{
		if (maze[i][j - 1] == roomSymbol && maze[i][j - 2] == roomSymbol && DFAlgorithm(maze, i, j - 2, step))//left
			return 1;
		if (maze[i + 1][j] == roomSymbol && maze[i + 2][j] == roomSymbol && DFAlgorithm(maze, i + 2, j, step))//down
			return 1;
		if (maze[i][j + 1] == roomSymbol && maze[i][j + 2] == roomSymbol && DFAlgorithm(maze, i, j + 2, step))//right
			return 1;
		if (maze[i - 1][j] == roomSymbol && (i != 1 && j != 1) && maze[i - 2][j] == roomSymbol && DFAlgorithm(maze, i - 2, j, step))//up
			return 1;
	}
	return 0;
}

int Maze::DFAlgorithmSecond(char**& maze, int i, int j, char& step)
{
	maze[i][j] = '$';
	if ((i == column - 2) && (j == row - 2))
	{
		maze[i][j] = step;
		return 1;
	}
	else
	{
		if (maze[i][j - 1] == roomSymbol && maze[i][j - 2] == roomSymbol && DFAlgorithmSecond(maze, i, j - 2, step))//left
		{
			maze[i][j - 1] = step;
			maze[i][j - 2] = step;
			return 1;
		}
		if (maze[i + 1][j] == roomSymbol && maze[i + 2][j] == roomSymbol && DFAlgorithmSecond(maze, i + 2, j, step))//down
		{
			maze[i + 1][j] = step;
			maze[i + 2][j] = step;
			return 1;
		}
		if (maze[i][j + 1] == roomSymbol && maze[i][j + 2] == roomSymbol && DFAlgorithmSecond(maze, i, j + 2, step))//right
		{
			maze[i][j + 1] = step;
			maze[i][j + 2] = step;
			return 1;
		}
		if (maze[i - 1][j] == roomSymbol && (i != 1 && j != 1) && maze[i - 2][j] == roomSymbol && DFAlgorithmSecond(maze, i - 2, j, step))//up
		{
			maze[i - 1][j] = step;
			maze[i - 2][j] = step;
			return 1;
		}
	}
	return 0;
}

int Maze::mazeAdapter(int i_column, int j_row)
{
	return (row - 1) / 2 * ((i_column + 1) / 2 - 1) + ((j_row + 1) / 2 - 1);

}

int Maze::findSet(int x)
{
	//���Ҹ����
	int r = x;
	while (r != unionFindSet[r])
		r = unionFindSet[r];
	//·��ѹ��
	int i = x;
	int j;
	while (i != r)
	{
		j = unionFindSet[i];
		unionFindSet[i] = r;
		i = j;
	}
	//���ظ����
	return r;
}

void Maze::uionSet(int x, int y)
{
	//����x��y�ĸ����
	int fx = findSet(x), fy = findSet(y);
	if (fx != fy)//���x��y�ĸ���㲻��ͬ
		unionFindSet[fx] = fy;
}

bool Maze::isJioned(int x, int y)
{
	//����x��y�ĸ����
	int fx = findSet(x), fy = findSet(y);
	//  cout<<"fx:"<<fx<<"   fy:"<<fy<<endl;
	if (fx == fy)//���x��y�ĸ���㲻��ͬ
		return true;
	else
		return false;
}

void Maze::printMaze(char** maze)
{
	for (int i = 0; i < column; i++)
	{
		for (int j = 0; j < row; j++)
		{
			cout << maze[i][j];
		}
		cout << endl;
	}
}

void Maze::printOriginalMaze()
{
	reStore(maze);
	printMaze(maze);
}

void Maze::printResultOfMaze()
{
	solveMazeSecond(maze);
	printMaze(maze);
}

void Maze::printStepOfMaze()
{
	solveMaze(maze);
	printMaze(maze);
}

void Maze::printUnionFindSet()
{
	for (int i = 0; i < UFSLength; i++)
	{
		cout << unionFindSet[i] << " ";
	}
	cout << endl;
}

void Maze::reStore(char**& maze)
{
	for (int i = 0; i < column; i++)
	{
		for (int j = 0; j < row; j++)
		{
			if ((maze[i][j] != wallCorner) && (maze[i][j] != wallSymbolH) && (maze[i][j] != wallSymbolV))
			{
				maze[i][j] = roomSymbol;
			}
		}
	}

}

void Maze::test()
{
	int row;
	int column;
	cout << "��ӭ�����Թ���Ϸ��" << endl;
	cout << "��������������Ҫ��ս���Թ��Ŀ�Ⱥ͸߶�" << endl;
	cout << "��������Ҫ��ս���Թ��Ŀ�ȣ�" << endl;
	while (cin >> row)
	{
		if (row < 1)
			cout << "�������,������������Ҫ��ս���Թ��Ŀ�ȣ�" << endl;
		else
			break;
	}

	cout << "��������Ҫ��ս���Թ��ĸ߶ȣ�" << endl;
	while (cin >> column)
	{
		if (column < 1)
			cout << "�������,������������Ҫ��ս���Թ��ĸ߶ȣ�" << endl;
		else
			break;
	}

	Maze *maze = new Maze(row, column);
	maze->printOriginalMaze();

	cout << endl << "�������Թ��ⷨ��" << endl;
	maze->printResultOfMaze();
	cout << endl << "�������Թ��������裺" << endl;
	maze->printStepOfMaze();

}