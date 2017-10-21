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
	char **maze;   //�Թ���̬��ά����
	int row;       //�Թ���̬��ά����һ�еĳ���
	int column;    //�Թ���̬��ά����һ�еĳ���
	int *unionFindSet;  //�����Թ��õĲ��鼯
	int UFSLength;      //���鼯�ĳ��ȣ�Ҳ�Ƿ�����ܸ���

	Maze(int row, int column);         //���캯��

	~Maze();                           //��������

	void initMaze(int row, int column, char**& maze);  //��ʼ���Թ�

	void makeMaze(char**& maze);                       //��������Թ�

	void solveMaze(char**& maze);                      //����Թ�

	void solveMazeSecond(char**& maze);                     //����Թ�

	int DFAlgorithm(char**& maze, int i, int j, char& step);    //�����㷨�������ɵ���������

	int DFAlgorithmSecond(char**& maze, int i, int j, char& step);  //�����㷨�������ɵڶ����Թ��Ľⷨ

	void initUnionFindSet(int*& unionFindSet);         //��ʼ�����鼯

	int mazeAdapter(int i_column, int j_row);          //�Ѷ�ά���顰���䡱�±�תΪ�ʺϲ��鼯���±�

	int findSet(int x);                                //���鼯�����Ҽ���

	void uionSet(int x, int y);                        //���鼯���ϲ�����

	bool isJioned(int x, int y);                       //�ж��������ϣ�Ԫ�ء��㣩�Ƿ���ͨ

	void printMaze(char** maze);                       //��ӡ�Թ�

	void printOriginalMaze();              //��ӡԭʼ�Թ�

	void printResultOfMaze();              //��ӡ�Թ��߷�

	void printStepOfMaze();                //��ӡ�Թ�����

	void printUnionFindSet();              //��ӡ���鼯

	void reStore(char**& maze);            //�ָ�ԭʼ�Թ�

	static void test();                           //���ڲ����Թ��㷨
};

#endif									 */