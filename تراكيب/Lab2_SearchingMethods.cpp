#include <cstdlib>
#include <iostream>
#include <algorithm>

using namespace std;

void fillArray(int array[], int size)
{
    for(int i = 0; i < size; i++)
    {
        array[i] =(rand() % 100);
    }
}



int linearSearch(int array[],int size, int key)
{
    for(int i = 0; i < size; i++)
    {
        if(key == array[i])
        return i;
    }
    return -1;
}



int binarySearch(int array [],int size, int key)
{
    int low = 0, high = size-1, mid = 0;
    while (low <= high)
    {
        mid = (low + high)/2;
        if(key == array[mid])
        return mid;
        else if (key < array[mid])
          high = mid - 1;
          else
          low = mid + 1;
    }
    return -1;
}



int main(int argc, char** argv)
{
    clock_t start, stop;
    
    int test[1000];
    
    cout<<"Linear Search = " ;
    start = clock();
     cout<<linearSearch(test , 100, 2);
     stop = clock();
    cout<<"\nBinary Search = " ;
     sort(test,test+100);
     cout<<binarySearch(test, 100 ,2);
     
     double totalTime = (double(stop)-double(start))/CLOCKS_PER_SEC;
     cout<<"  \nTotal time =";
     cout<<totalTime;
     
    return 0;
}