#include<stdio.h>

int main(){
    char str[10] = {'B', 'h','o','p','a','l','o','p','a','l'};
    for(int i=0;str[i]!= '\0';i++)
    {
     printf("%c\n", str[i]);
    }

    return 0;
}