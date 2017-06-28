#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//Yapımızın genel özellikleri
struct Node {
    const char *name;
    int value;
    struct Node *next;
};
struct Table {
    struct Node *first;
};
struct Table *Table_create(void){
    struct Table *t;
    t = (struct Table*)malloc(sizeof(struct Table));//bellekte yer acilir.
    t->first=NULL;//t'ilk olusturulduğunda first'i null'ı isaret eder.
    return t;
};
void Table_add(struct Table *t,const char *name,int value){

    struct Node *p = (struct Node*)malloc(sizeof(struct Node));
    printf("Ad : %s , Yas : %d",name,value);
    p->name = name;
    p->value = value;
    p->next = t->first;
    t->first = p;
    printf("--->Eklendi\n");
}
int Table_search(struct Table *t,const char *name,int *value){
    struct Node *p;
    for(p = t->first; p!=NULL; p=p->next)
        if(strcmp(p->name,name)==0){//name'leri aynı olan var mı
            *value = p->value;
            return 1;
        }
    return 0;
}
void Table_free(struct Table *t){
    struct Node *p;
    struct Node *nextp;
    for(p=t->first; p!=NULL; p=nextp){
        nextp = p->next;
        free(p);
    }
    free(t);
     printf("\nListe silindi\n");
}

int main()
{
    struct Table *t;
    t = Table_create();//node olusturuldu
    Table_add(t,"Murat Can",23);//eklendi
    Table_add(t,"Recep Ali",56);

    int value;
    int sonuc = Table_search(t,"Recep Ali VARER",&value);//boyle bir kayıt var mı
    printf("Sonuc = %d",sonuc);//varsa sonuc 1 değilse 0
    Table_free(t);//yapı silinir.
    //sonuc = Table_search(t,"Recep Ali VARER",&value);
    //printf("Sonuc = %d",sonuc);
    return 0;
}
