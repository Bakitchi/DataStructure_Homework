#include <stdio.h>
 #include <stdlib.h>
 #include <math.h>
 #include<string.h>

 #define OK    1
 #define ERROR 0
 #define STACK_INIT_SIZE 50
 #define STACKINCREMENT   2

  typedef int  Status;
  typedef char SElemType;

  typedef struct SqStack
  {
      SElemType *base;
      SElemType *top;
      int stacksize;
  }SqStack;

  Status InitStack(SqStack &S)
  {
     S.base = (SElemType *)malloc(STACK_INIT_SIZE*sizeof(SElemType));
     if (!S.base)
     {
          exit(OVERFLOW);
     }
     S.top = S.base;
     S.stacksize = STACK_INIT_SIZE;
     return OK;
  }

  Status GetTop(SqStack S, SElemType &e)
  {
       if(S.top == S.base)
       {
            return ERROR;
       }
       e = *(S.top - 1);
       return OK;
  }

  Status StackEmpty(SqStack &S)
  {
      if (S.base == S.top)
      {
          return OK;
      }
      else
      {
          return ERROR;
      }
  }

  Status Push(SqStack &S,SElemType e)
  {
      if (S.top - S.base >= S.stacksize)
      {
          S.base = (SElemType *)realloc(S.base,(S.stacksize + STACKINCREMENT)*sizeof(SElemType));
          if (!S.base)
              exit(OVERFLOW);
          S.top = S.base + S.stacksize;
          S.stacksize +=STACKINCREMENT;
      }
      *S.top++ = e;
      return OK;
  }

  Status Pop(SqStack &S,SElemType &e)
  {
      if (S.base == S.top)
      {
          return ERROR;
      }
      e = *--S.top;
      return OK;
  }

 Status MatchCheck(char L[])
  {
      SqStack s;
	  InitStack(s);
      char e;
      for(int i=0;i<strlen(L);i++)
     {
         if(L[i]=='('||L[i]=='{'||L[i]=='[')
         {
             Push(s,L[i]);
         }
         else if(L[i]==')')
         {
             if(GetTop(s,e))
             {
                 if(e=='(')
                 {
                     Pop(s,e);
                 }
                 else
                 {
                     Push(s,L[i]);
                     break ;
                 }
             }
             else
             {
                 Push(s,L[i]);
                 break ;
             }
         }
         else if(L[i]=='}')
         {
             if(GetTop(s,e))
             {
                 if(e=='{')
                 {
                     Pop(s,e);
                 }
                 else
                 {
                     Push(s,L[i]);
                     break ;
                 }
             }
             else
             {
                 Push(s,L[i]);
                 break ;
             }
         }
         else if(L[i]==']')
         {
             if(GetTop(s,e))
             {
                 if(e=='[')
                 {
                     Pop(s,e);
                 }
                 else
                 {
                     Push(s,L[i]);
                     break ;
                 }
             }
             else
             {
                 Push(s,L[i]);
                 break ;
             }
         }
     }
     if(StackEmpty(s))
     {
         printf("匹配合法\n");
     }
     else
     {
         printf("匹配不合法\n");
     }
     return 0;
 }
 
 int main()
 {
       char str[20];
       printf("请输入括号序列；\n");
       gets(str);
       MatchCheck(str);
       return 0;
 }


