// tested by code@sumithpuri.xyz on [18/Dec/2022]
// please star/like, follow & fork from my github
// pls. refer https://onecompiler.com/c/3ys6wgjwh

#include <stdio.h>
#include <stdlib.h>
//#include <conio.h>

#define TRUE 1
#define FALSE 0
#define MAX 8

int visited[8];

// using adjacency lists
struct dfs {
    int vertex;
    struct dfs *adjlist;
};

struct dfs *dfsList[8];

void depthFirstSearch();

void createGraph(int vertex, char *adjList, int value) {    

    struct dfs *newNode;
    newNode=(struct dfs*) malloc(sizeof(struct dfs));
    newNode->vertex=vertex;
    newNode->adjlist=NULL;
    if(value!=-1) {
        dfsList[value]=newNode;
        printf("\nroot %d ", dfsList[value]->vertex); // debug message
        value=-1; // degenerate current start pointer
    }
    while(*adjList!='X') {
        struct dfs *listNode;
        listNode = (struct dfs*) malloc(sizeof(struct dfs));
        listNode->vertex=((*adjList)-48);
        listNode->adjlist=NULL;
        newNode->adjlist=listNode;
        printf("with %d ", listNode->vertex); // debug message
        newNode=listNode;
        adjList++;
            
    }
    
    return ;
}


int main() {
    
    printf("\ndepth first search (c) sumith kumar puri, 2013");
    printf("\nfeel free to distribute, include and circulate");
    printf("\n\n");
    
    int x=0;
    for(x=0;x<8;x++) visited[x]=0;
    
    
    /*
                         __v1__
                       /        \ 
                      /          \
                    v2--v5    v6--v3
                    /     \  /     |
                   v4------v8 ----v7    
    
    */
    
    
    createGraph(1,"23X", 0);
    createGraph(2,"145X", 1);
    createGraph(3,"167X", 2);    
    createGraph(4,"28X", 3);    
    createGraph(5,"28X", 4);    
    createGraph(6,"38X", 5);    
    createGraph(7,"38X", 6);
    createGraph(8,"4567X", 7);
    
    printf("\n\nstarting depth first search for the graph..\n");

    depthFirstSearch(1,dfsList);
               
    // getch();
    return 0;
}



void depthFirstSearch(int v, struct dfs **nodes) {
    
    struct dfs *q;
    visited[v - 1]=TRUE;
    
    printf("%d ",v);
    
    q=*(nodes+v-1);    
    while(q!=NULL) {
        if(visited[(q->vertex)-1]==FALSE) {            
            depthFirstSearch((q->vertex),nodes);
        } else {
            q=q->adjlist;
        }
    }   
}
