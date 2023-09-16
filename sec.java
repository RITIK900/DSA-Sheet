public class sec {
    /*
        a = mergeSort(a, 0, a.length-1);

        for(int i=0;i<a.length;i++)
          System.out.print(a[i] + " ");
          */
    public static void main(String[] args) {
        int[] a={ 1 ,2 ,3 ,4 ,4 ,5};
        int k=4;

        int firstIndex = firstOcurrence(a, 0, a.length-1, k);
        int lastIndex = lastOcurrence(a, 0, a.length-1, k);

        System.out.println(firstIndex+" ,"+lastIndex);

    }

    static int firstOcurrence(int[] a, int st, int end, int k)
    {
       /* if(st == end)
        {
            if(st == 0 && a[st] == k)
             return st;

            if(st>0 && a[st] == k && a[st] != a[st-1])
             return st;
             
        }*/
        if(st < end)
        {
            int mid = st+(end-st)/2;


            if(mid == 0)
                if(a[mid] ==k)
                 return mid;
            if(mid > 0)
                if((a[mid] ==k) && (a[mid] != a[mid-1]))
                   return mid;
            
            if(a[mid] > k)
             return firstOcurrence(a, mid+1, end, k);
            
             return firstOcurrence(a, st, mid-1, k);
        }

        return -1;
    }

    static int lastOcurrence(int[] a, int st, int end, int k)
    {
        if(st == end)
        {
            if(st == a.length-1 && a[st] == k)
             return st;

            if(st<(a.length-1) && a[st] == k && a[st] != a[st+1])
             return st;
             
        }
        if(st < end)
        {
            int mid = st+(end-st)/2;


            if(mid == a.length-1)
                if(a[mid] ==k)
                 return mid;
            if(mid < a.length-1)
                if((a[mid] ==k) && (a[mid] != a[mid+1]))
                   return mid;
            
            if(a[mid] > k)
             return lastOcurrence(a, mid+1, end, k);
            
            return lastOcurrence(a, st, mid-1, k);
        }

        return -1;
    }

    static int[] mergeSort(int[] a, int st, int end)
    {
        if(st<end)
        {
            int mid = st+(end-st)/2;

            int[] left = mergeSort(a, st, mid);
            int[] right = mergeSort(a, mid+1, end);

            return merge(a, st, mid, end);
        }

        return a;
    }

    static int[] merge(int[] a, int st, int mid, int end)
    {
        int l1 = mid-st+1;
        int l2 = end - mid;
        int[] left = new int[l1];
        int[] right = new int[l2];

        int i=st,j=0;
        for(;i<=mid;i++)
         left[j++] = a[i];
        
        j=0;
        while(i<=end)
         right[j++] = a[i++];

         i=0;
         j=0;
         int k=st;
        for(;k<=end && (i<l1) && (j<l2);k++)
        {
            if(left[i] < right[j])
            {
                a[k] = left[i++];
            }
            else
             a[k] = right[j++];
        }
        while(i<l1)
         a[k++] = left[i++];
        while(j<l2)
         a[k++] = right[j++];

        return a;
    }
}
