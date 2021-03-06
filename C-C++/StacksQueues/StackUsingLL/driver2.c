#include<stdio.h>
#include<stdlib.h>
struct stackNode{
	int element;
	struct stackNode* next;
};

struct stack{
	struct stackNode* head;
	int size;
};

struct stack initializeStack();
struct stackNode* createNode(int);
struct stack push(struct stack, int );
struct stack pop(struct stack);
int peek(struct stack);
void print(struct stack);

int main (){
struct stack initializeStack(){
	struct stack s;
	s.head = NULL;
	s.size = 0;
	return s;
}

struct stackNode* createNode(int element){
	struct stackNode* s;
	s = (struct stackNode*) malloc(sizeof(struct stackNode));
	if(s == NULL){
		printf("Memory full");
		exit(0);
	}
	s->element = element;
	s->next = NULL;
	return s;
}

struct stack push(struct stack s, int element){
	struct stackNode* node = createNode(element);
	if(s.size == 0){
		s.head = node;
		s.size++;
		return s;
	}
	else{
		node->next = s.head;
		s.head = node;
		s.size++;
		return s;
	}
}

struct stack pop(struct stack s){
	if(s.size == 0){
		printf("Stack is empty. Nothing to pop");
		exit(0);
	}
	s.head = s.head->next;
	s.size--;
	return s;
}

void print(struct stack s){
	struct stackNode* temp = s.head;
	while(temp != NULL){
		printf("%d ->", temp->element);
		temp = temp->next;
	}
	printf("null\n");
}

int peek(struct stack s){
	if(s.size == 0){
		printf("Stack is empty. Nothing to peek\n");
		exit(0);
	}
	return s.head->element;
}

	struct stack S = initializeStack();
	S = push(S, 1);
	S = push(S, 2);
	S = push(S, 4);
	S = push(S, 8);
	print(S);
	
	printf("top -> %d\n", peek(S));
	S = pop(S);
	print(S);
	S = pop(S);
	S = pop(S);
	S = pop(S);	
	S = pop(S);
	return 0;
}
