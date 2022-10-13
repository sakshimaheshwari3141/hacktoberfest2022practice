

//Fenwick tree best implementation

import java.util.*;
public class FenWickTree {
    int tree[];
    FenWickTree(int values[]) {
        int n = values.length-1;
        tree = new int[n+1];
        this.tree = values.clone();
        //o(n)
        for(int i=1;i<=n;i++) {
            int j = i+lsb(i);
            if(j<=n) {
                tree[j] += tree[i];
            }
        }

    }

    int lsb(int x) {
        return x&(-x);
    }
    //logn
    int prefixSum(int index) {
        int sum = 0;
        while(index!=0) {
            sum+= tree[index];
            index -= lsb(index);
        }
        return sum;
    }
    //logn
    int rangeQuery(int left,int right) {
        return prefixSum(right)-prefixSum(left-1);
    }

    //logn
    void updateHelper(int index,int diff,int n) {
        while(index<=n) {
            tree[index] += diff;
            index += lsb(index);
        }
    }

    void update(int index,int new_value) {
        int diff = new_value-tree[index];
        int n = tree.length;
        updateHelper(index, diff, n);
    }

    public static void main(String[] args) {
        int arr[] =  {0, 3, 2, 7, 9, 11};
        FenWickTree root = new FenWickTree(arr);
        System.out.println(root.rangeQuery(1, 4));

        root.update(1, 5);

        System.out.println(root.rangeQuery(1, 4));
    }

}
