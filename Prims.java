import java.util.*;
public class Prims {
    
        public static void main(String[] args) {
            Scanner ob = new Scanner(System.in);
            int n = ob.nextInt();
            int m = ob.nextInt();
            Set<Long> set = new HashSet<Long>();
            for (int i=0;i<m;i++) {
                long fr = (long)ob.nextInt();
                long to = (long)ob.nextInt();
                long w = (long)ob.nextInt();
                set.add(w+(fr<<20)+(to<<32));
            }
            int z = 1;
            Set<Long> vs = new HashSet<Long>();
            vs.add(1l);
            long sum = 0;
            while (z<n) {
                long min = Integer.MAX_VALUE;
                long min_fr = -1;
                long min_to = -1;
                Set<Long> toRemove = new HashSet<Long>();
                for (long l:set) {
                    long fr = (l>>20)%(1<<12);
                    long to = l>>32;
                    long w = l%(1<<20);
                    if (vs.contains(fr) && vs.contains(to)) {
                        toRemove.remove(l);
                    } else {
                     if (vs.contains(fr) || vs.contains(to)) {
                            if (w<min) {
                                min = w;
                                min_fr = fr;
                                min_to = to;
                            }    
                        }
                    }
                }
                vs.add(min_fr);
                vs.add(min_to);
                sum += min;
                set.removeAll(toRemove);
                z++;
            }
            System.out.println(sum);
            ob.close();
        }
    }
