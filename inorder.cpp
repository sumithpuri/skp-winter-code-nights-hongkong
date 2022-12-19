// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github
// pls. refer https://onecompiler.com/c/3ys9rac23

#include <iostream>

using namespace std;

struct bst {
    int value;
    struct bst *right;
    struct bst *left;
};

void addToBST(bst*, int);

struct bst *root=NULL;
int i=0;

void addToBST(struct bst *curr, int value) {

    if(curr==NULL) {
        bst *newNode;
        newNode=(struct bst*) malloc (sizeof(struct bst));
        newNode->value=value;
        newNode->right=NULL;
        newNode->left=NULL;
        curr=newNode;
        root=curr;
        return;
    }
    
    if(value >= curr->value) {
        if(curr->right != NULL) {
            addToBST(curr->right, value);
        } else {
            bst *newNode;
            newNode=(struct bst*) malloc (sizeof(struct bst));
            newNode->value=value;
            newNode->right=NULL;
            newNode->left=NULL;
            curr->right=newNode;
        }
    } else {
        if(curr->left != NULL) {
            addToBST(curr->left, value);
        } else {
            bst *newNode;
            newNode=(struct bst*) malloc (sizeof(struct bst));
            newNode->value=value;
            newNode->right=NULL;
            newNode->left=NULL;
            curr->left=newNode;
        }
    }
    return;
}


void inorder(struct bst* trv) {
    if(trv != NULL) {
        inorder(trv->left);
        cout << endl << trv->value;
        inorder(trv->right);
    } 
}

int main(int argc, char *argv[]) {
    cout << "inorder tree traversal (c) sumith kumar puri" << endl;
    cout << "feel free to distribute, modify and include" << endl;
    cout << "--------------------------------------------" << endl;
   
    cout  << endl << "first of all, building a binary search tree";
    cout << endl << "9 7 6 1 3 5 4 2 8 are the inserted elements";
    
    addToBST(root,9);
    addToBST(root,7);
    addToBST(root,6);        
    addToBST(root,1);
    addToBST(root,3);
    addToBST(root,5);
    addToBST(root,4);
    addToBST(root,2);
    addToBST(root,8);                             
    
    cout << endl << "succesfully have build the binary search tree";
    cout << endl << endl << "starting inorder traversal";
    inorder(root);
    // getch();    
}
