#include<stdio.h>
int main(){

    char word[1000000];
    int s[26]={0};
    scanf("%s", word);
    for(int i=0;word[i]!='\0';i++){
        if(word[i]<91)
                s[word[i]-65]++;
        else
                s[word[i]-97]++;
    }
    int n=0;int exc=0;
    for(int i=1;i<26;i++){
        if(s[n]<s[i])
                n=i;
        else if(s[n]==s[i])
                exc++;
    }
    if(exc){
        for(int i=n+1;i<26;i++)
            if(s[n]==s[i])
            {printf("?\n");return 0;}
    }
    printf("%c\n",n+65);

 return 0;
}
