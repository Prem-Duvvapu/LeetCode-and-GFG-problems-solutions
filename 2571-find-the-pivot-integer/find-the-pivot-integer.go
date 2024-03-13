func pivotInteger(n int) int {
    sum := (n*(n+1))/2
    
    for i:=1; i<=n ;i++ {
        currSum := (i*(i+1))/2
        if (currSum==(sum-currSum+i)) {
            return i
        }
    }


    return -1
}