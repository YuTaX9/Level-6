#include <bits/stdc++.h>

using namespace std;

void fillArray_1D(int array[],int size)
{
    for(int i=0;i<size;i++)
    {
        array[i] = rand()%100;
    }
}

void fillArray_2D(int array[3][4])
{
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<4;j++)
        {
            array[i][j] = rand()%100;
        }
    }
}

void printArray_1D(int array[],int size)
{
    for(int i=0;i<size;i++)
    {
        cout<<array[i]<<", ";
    }
    cout<<endl;
}

void printArray_2D(int array[3][4])
{
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<4;j++)
        {
            cout<<array[i][j]<<"\t";
        }
        cout<<endl;
    }
}

void belowAboveAvg(int array[],int size)
{
    double sum=0;
    double avg =0;
    int count=0;

    while (count<size)
    {
    sum = sum + array[count];
    count = count + 1;
    }

    avg = sum/size;
    cout<<"The average of all elements of the array is "<<avg<<endl;
    cout<<endl;
    int aboveAvg=0,belowAvg=0;

    for(int i=0;i<size;i++)
    {
        if(array[i]>avg)
        aboveAvg++;

        else if(array[i]<avg)
        belowAvg++;
    }

    cout<<"The number of elements above average is: "<<aboveAvg<<endl;
    cout<<endl;
    cout<<"The elements above average are as follows:"<<endl;

    for(int i=0;i<size;i++)
    {
        if(array[i]>avg)
        cout<<array[i]<<", ";
    }

    cout<<endl;
    cout<<endl;
    cout<<"The number of elements below average is: "<<belowAvg<<endl;
    cout<<endl;
    cout<<"The elements below average are as follows:"<<endl;

    for(int i=0;i<size;i++)
    {
        if(array[i]<avg)
        cout<<array[i]<<", ";
    }

    cout<<endl;
}

void swapLargestSmallest(int array[],int size)
{
    cout<<"Before swapping largest and smallest:"<<endl;
    cout<<"Elements of the array are as follows:"<<endl;

    for(int i=0;i<size;i++)
    {
        cout<<array[i]<<", ";
    }

    cout<<endl;
    cout<<endl;

    int smallest = array[0];
    int largest = array[0];
    int small_idx=0;
    int large_idx=0;
    int count=0;

    while(count<size)
    {
        if(array[count]<smallest)
        {
            smallest = array[count];
            small_idx = count;
        }
        if(array[count]>largest)
        {
            largest = array[count];
            large_idx = count;
        }
        count = count + 1;
    }

    int temp = array[small_idx];
    array[small_idx] = array[large_idx];
    array[large_idx] = temp;
    cout<<"Largest element of the array is: "<<largest<<endl;
    cout<<endl;
    cout<<"Smallest element of the array is: "<<smallest<<endl;
    cout<<endl;
    cout<<"After swapping largest and smallest:"<<endl;
    cout<<"Elements of the array are as follows:"<<endl;

    for(int i=0;i<size;i++)
    {
        cout<<array[i]<<", ";
    }

    cout<<endl;
}

void SumRowsColumns(int array[3][4])
{
    cout<<"The elements of the array with the sum of rows and columns are as follows:"<<endl;
    int rowSum[3],colSum[4];
    memset(rowSum,0,sizeof(rowSum));
    memset(colSum,0,sizeof(colSum));

    for(int i=0;i<3;i++)
    {
        for(int j=0;j<4;j++)
        {
            rowSum[i] = rowSum[i] + array[i][j];
        }
    }

    for(int i=0;i<4;i++)
    {
        for(int j=0;j<3;j++)
        {
            colSum[i] = colSum[i] + array[j][i];
        }
    }

    for(int i=0;i<3;i++)
    {
        cout<<"    \t";
        for(int j=0;j<4;j++)
        {
            cout<<array[i][j]<<"\t";
        }
        cout<<"Sum: "<<rowSum[i]<<endl;
    }

    cout<<"Sum:\t";

    for(int i=0;i<4;i++)
    {
        cout<<colSum[i]<<"\t";
    }

}

void repeatedElementsRow(int array[3][4])
{
    int repeatRow[3];
    int flag=0;
    memset(repeatRow,0,sizeof(repeatRow));

    for(int i=0;i<3;i++)
    {
        for(int j=0;j<4;j++)
        {
            int num = array[i][j];
            for(int k=j+1;k<4;k++)
            {
                if(num==array[i][k])
                {
                    flag=1;
                    repeatRow[i] = 1;
                    break;
                }
            }
        }
    }

    if(flag==1)
    {
        cout<<"Rows containing repeated elements"<<endl;

        for(int i=0;i<3;i++)
        {
            if(repeatRow[i]==1)
            {
                cout<<"\t";
                for(int j=0;j<4;j++)
                {
                    cout<<array[i][j]<<"\t";
                }
                cout<<endl;
            }
        }
    }

    else
    {
        cout<<"No Row contains duplicate elements"<<endl;
    }

}

int main()
{
    cout<<"**************************"<<endl;
    cout<<"*********Array Exercises***********"<<endl;
    cout<<"***************************"<<endl;

    srand(unsigned(time(0)));

    cout<<endl;
    cout<<"Tasks related to 1-D"<<endl;

    int noOfelements;
    cout<<"How many elements of the 1D array? ";
    cin>>noOfelements;

    int test1D[noOfelements];
    fillArray_1D(test1D,noOfelements);
    cout<<"Elements of the array are as follows:"<<endl;
    printArray_1D(test1D,noOfelements);
    cout<<endl;

    cout<<"Task 1:"<<endl;
    cout<<endl;
    belowAboveAvg(test1D,noOfelements);
    cout<<endl;

    cout<<"Task 2:"<<endl;
    swapLargestSmallest(test1D,noOfelements);
    cout<<endl;
    cout<<"Tasks related to 2-D"<<endl;
    cout<<endl;
    int test2D[3][4];
    cout<<"Entering random numbers in matrix of 3 rows and 4 columns:"<<endl;
    fillArray_2D(test2D);
    printArray_2D(test2D);
    cout<<endl;

    cout<<"Task 3:"<<endl;
    SumRowsColumns(test2D);
    cout<<endl;
    cout<<endl;

    cout<<"Task 4:"<<endl;
    cout<<endl;
    cout<<"Entering random numbers in matrix of 3 rows and 4 columns:"<<endl;
    printArray_2D(test2D);
    cout<<endl;
    repeatedElementsRow(test2D);

    return 0;
}