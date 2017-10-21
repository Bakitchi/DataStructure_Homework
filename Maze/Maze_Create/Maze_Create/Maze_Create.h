#pragma once

#include<iostream>
#include <ctime>
#ifndef MAZE_H
#define MAZE_H
const char resultSymbol = '#';
const char wallSymbolH = '-';
const char wallSymbolV = '|';
const char wallCorner = '+';
const char roomSymbol = ' ';

class Maze
{
public:
	char **maze;   //迷宫动态二维数组
	int row;       //迷宫动态二维数组一行的长度
	int column;    //迷宫动态二维数组一列的长度
	int *unionFindSet;  //生成迷宫用的并查集
	int UFSLength;      //并查集的长度，也是房间的总个数

	Maze(int row, int column);         //构造函数

	~Maze();                           //析构函数

	void initMaze(int row, int column, char**& maze);  //初始化迷宫

	void makeMaze(char**& maze);                       //随机首先迷宫

	void solveMaze(char**& maze);                      //解决迷宫

	void solveMazeSecond(char**& maze);                     //解决迷宫

	int DFAlgorithm(char**& maze, int i, int j, char& step);    //深搜算法用于生成的搜索步骤

	int DFAlgorithmSecond(char**& maze, int i, int j, char& step);  //深搜算法用于生成第二个迷宫的解法

	void initUnionFindSet(int*& unionFindSet);         //初始化并查集

	int mazeAdapter(int i_column, int j_row);          //把二维数组“房间”下标转为适合并查集的下标

	int findSet(int x);                                //并查集：查找集合

	void uionSet(int x, int y);                        //并查集：合并集合

	bool isJioned(int x, int y);                       //判断两个集合（元素、点）是否连通

	void printMaze(char** maze);                       //打印迷宫

	void printOriginalMaze();              //打印原始迷宫

	void printResultOfMaze();              //打印迷宫走法

	void printStepOfMaze();                //打印迷宫步骤

	void printUnionFindSet();              //打印并查集

	void reStore(char**& maze);            //恢复原始迷宫

	static void test();                           //用于测试迷宫算法
};

#endif									 */