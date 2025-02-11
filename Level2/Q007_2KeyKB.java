package Level2;

public class Q007_2KeyKB {
    public int minSteps(int sc, int cbc, int n){
        if(sc+cbc > n){
            return -1;
        }
        if(sc+cbc == n){
            return 1;
        }

        if(sc == cbc){
            int ans = minSteps(2*sc,cbc,n);
            if(ans == -1){
                return -1;
            }
            return 1+ans;
        }
        int ans1 = minSteps(sc, sc,n);//copy
        int ans2 = minSteps(sc+cbc,cbc,n);//paste
        if(ans1 != -1 || ans2 != -1){
            return 1+((ans1!=-1)?ans1:ans2);
        }
        return -1;
    }
}
