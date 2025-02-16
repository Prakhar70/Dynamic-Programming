package Level2;

public class Q007_2KeyKB {
    public int minSteps(int n) {
        return minSteps(1, 0, n);
    }

    private int minSteps(int sc, int cbc, int n) {
        if(sc == n){
            return 0;
        }
        if(sc > n){
            return -1;//not possible
        }
        int paste = -1;
        if(cbc > 0){
            paste = minSteps(sc+cbc,cbc,n);
        }
        int copy = -1;
        if(sc != cbc){
            copy = minSteps(sc, sc, n);
        }
        if(copy == -1 && paste == -1){
            return -1;
        }
        if(copy == -1 || paste == -1){
            return copy!=-1?copy+1:paste+1;
        }
        return Math.min(copy,paste)+1;
    }
}
