class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        int maxLength = 1;
        int currLength = 0;
        boolean nextShouldBeSmaller = false;

        int j = 0;

        while (j<n-1 && arr[j]==arr[j+1]) {
            j++;
        }

        if (j == n-1) {
            return 1;
        }

        if (j<n-1 && arr[j] < arr[j+1]) {
            nextShouldBeSmaller = false;
        } else if (j<n-1 && arr[j] > arr[j+1]) {
            nextShouldBeSmaller = true;
        }

        currLength = 2;
        j++;

        maxLength = Math.max(maxLength, currLength);

        while (j < n-1) {
            if (nextShouldBeSmaller) {
                if (arr[j] < arr[j+1]) {
                    currLength++;
                    nextShouldBeSmaller = false;
                } else {
                    while (j<n-1 && arr[j]==arr[j+1]) {
                        j++;
                    }

                    if (j == n-1) {
                        return maxLength;
                    }

                    if (j<n-1 && arr[j] < arr[j+1]) {
                        nextShouldBeSmaller = false;
                        currLength =  2;
                    } else if (j<n-1 && arr[j] > arr[j+1]) {
                        nextShouldBeSmaller = true;
                        currLength = 2;
                    }
                }
            } else {
                if (arr[j] > arr[j+1]) {
                    currLength++;
                    nextShouldBeSmaller = true;
                } else {
                    while (j<n-1 && arr[j]==arr[j+1]) {
                        j++;
                    }

                    if (j == n-1) {
                        return maxLength;
                    }

                    if (j<n-1 && arr[j] < arr[j+1]) {
                        nextShouldBeSmaller = false;
                        currLength =  2;
                    } else if (j<n-1 && arr[j] > arr[j+1]) {
                        nextShouldBeSmaller = true;
                        currLength = 2;
                    }
                }
            }

            maxLength = Math.max(currLength, maxLength);
            j++;
            // System.out.println("j="+j);
        }

        return maxLength;
    }
}

/*
3,3,3,1,7,6,8,8,8,4
    j

1,8,8,8,4
  p
maxLength = 1
currLength = 1
nextShouldbeSmaller = false



[5,7,9,2,6]
 0 1 2 3 4

1st case:
9 7 10
1 2 3

s     g   s  g
even  odd 

g     s   g   s
even odd 

2nd case:
7,9,2
1 2 3

keep moving as long continuous equal elements

[9,4,2,10,7,8,8,1,9]
 0 1 2  3 4 5 6 7 8 
                  p 

 maxLength = 5
 currLength = 3
 currentShouldbeSmall = false


*/