class ATM {
    private int[] freq;
    private Map<Integer,Integer> notes;
    int j=0;

    public ATM() {
        freq=new int[5];
        notes=new HashMap<>();
        notes.put(0,20);
        notes.put(1,50);
        notes.put(2,100);
        notes.put(3,200);
        notes.put(4,500);
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i=0;i<freq.length;i++)
            freq[i]+=banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        int temp=amount;
        int i=freq.length-1;
        int[] withDrawedNotes=new int[5];

        while (i>=0 && temp>0) {
            int canWithDraw=Math.min(freq[i],temp/notes.get(i));
            temp=temp-canWithDraw*notes.get(i);
            i--;
        }

        if (temp>0)
            return new int[]{-1};

        i=freq.length-1;
        temp=amount;
        while (i>=0 && temp>0) {
            withDrawedNotes[i]=Math.min(freq[i],temp/notes.get(i));
            temp=temp-withDrawedNotes[i]*notes.get(i);
            freq[i]-=withDrawedNotes[i];
            i--;
        }

        return withDrawedNotes;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */