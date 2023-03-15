import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Hashing {

    // What is hashing?
    // Hashing is a technique that is used to convert a given key into an index of an array.
    // The index is used to access the value from the array.

    /*
     * Why hashing is preferred over searching?
     * 1. Hashing is faster than searching, because searching requires comparison.
     * 2. Hashing requires less memory compared to searching.
     * 3. In hashing, a hashing function is used which maps keys to specific locations for faster access of elements.
     * 4. Hashing is used to implement associative arrays and databases.
     */
     
     /*
      * Why hashing is better than arrays or Binary search trees?
        * 1. Arrays take O(logn) time to search, O(n) time to insert and delete. Binary Search Trees take O(Logn) time to search, insert and delete.
        * 2. Hashing takes only O(1) time to search, insert and delete.
      */

      /*
       * Where hashing is not used?
       * 1. When it is required that the table be sorted.
       * 2. When it is required that the table supports range queries (eg. find all records within key values x and y).
       * 3. Prefix searching (eg. find all words in dictionary with given prefix) is not supported by hashing.
       * 4. Finding closest match is not supported by hashing.
       */
       
       /*
        * Applications of Hashing
        1. Dictionary
        2. Database indexing
        3. Caches (CPU, Web server, etc.)
        4. Hashing is used in sets and unordered maps, implemented as hashtables, to allow for fast lookup.
        5. Hashing is also used in ordered maps, implemented as ordered hashtables, to allow for fast lookup and maintain the order of elements.
        6. Cryptographic applications
        7. Compilers
        8. Network routing algorithms

        */

        /*
         * Direct Address Table
         * 1. Direct Address Table is a simple hash table where the key is the address of the element.
         * 2. It is used when the keys are small integers.
         * 3. It makes searching, insertion and deletion in O(1).
         * 4. We create a boolean array of size m, where m is the maximum key value.
         * 5. We set the value of the array at index i to true if the key i is present in the table.
         * 6. We set the value of the array at index i to false if the key i is not present in the table.
         
         */

         /*
          * Collision Handling Techniques
          * 1. Separate Chaining -- https://www.geeksforgeeks.org/separate-chaining-collision-handling-technique-in-hashing/
          * 2. Open Addressing -- https://www.geeksforgeeks.org/open-addressing-collision-handling-technique-in-hashing/
                Double Hashing -- https://www.geeksforgeeks.org/double-hashing/
          */

        // Implementation of Open Addressing

        class MyOpenAddressingHash{

          int[] arr;;
          int capacity;
          int size;
          MyOpenAddressingHash(int c){
            capacity = c;
            size = 0;
            arr = new int[capacity];
            for(int i = 0; i < capacity; i++){
              arr[i] = -1;
            }
          }

          int hash1(int key){
            return key % capacity;
          }

          int hash2(int key){
            return 7 - (key % 7); // 7 is just an example, it can be any prime number relatively prime to capacity and smaller than capacity
          }

          boolean insert(int key){
            if(size == capacity){
              return false;
            }
            int index = hash1(key);
            if(arr[index] != -1){
              int index2 = hash2(key);
              int i = 1;
              while(true){
                int newIndex = (index + i * index2) % capacity;
                if(arr[newIndex] == -1){
                  arr[newIndex] = key;
                  break;
                }
                i++;
              }
            }else{
              arr[index] = key;
            }
            size++;
            return true;
          }

          boolean search(int key){
            int index = hash1(key);
            if(arr[index] == key){
              return true;
            }
            int index2 = hash2(key);
            int i = 1;
            while(true){
              int newIndex = (index + i * index2) % capacity;
              if(arr[newIndex] == key){
                return true;
              }
              if(arr[newIndex] == -1){
                return false;
              }
              i++;
            }
          }

          boolean erase(int key){
            int index = hash1(key);
            if(arr[index] == key){
              arr[index] = -2;
              size--;
              return true;
            }
            int index2 = hash2(key);
            int i = 1;
            while(true){
              int newIndex = (index + i * index2) % capacity;
              if(arr[newIndex] == key){
                arr[newIndex] = -2;
                size--;
                return true;
              }
              if(arr[newIndex] == -1){
                return false;
              }
              i++;
            }
          }
        }

        public void printFrequenciesOfArrayElements(int[] arr){
          HashMap<Integer, Integer> map = new HashMap<>();
          for (int x : arr)
              map.put(x, map.getOrDefault(x, 0) + 1);
          for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
          } 

        }

        public List<Integer> intersectionOfTwoArrays(int[] arr1, int[] arr2){
          HashSet<Integer> set = new HashSet<>();
          for (int x : arr1)
              set.add(x);
          List<Integer> list = new ArrayList<>();
          for (int x : arr2){
            if(set.contains(x)){
              list.add(x);
              set.remove(x);
            }
          }
          return list;
        }

        public List<Integer> unionOfTwoArrays(int[] arr1, int[] arr2){
          HashSet<Integer> set = new HashSet<>();
          for (int x : arr1)
              set.add(x);
          for (int x : arr2)
              set.add(x);
          List<Integer> list = new ArrayList<>();
          for (int x : set){
            list.add(x);
          }
          return list;
        }

        public boolean isPairWithGivenSumPresent(int[] arr, int sum){
          HashSet<Integer> set = new HashSet<>();
          for (int x : arr){
            if(set.contains(sum - x)){
              return true;
            }
            set.add(x);
          }
          return false;
        }

        public boolean isPairWithGivenDifferencePresent(int[] arr, int diff){
          HashSet<Integer> set = new HashSet<>();
          for (int x : arr){
            if(set.contains(x + diff) || set.contains(x - diff)){
              return true;
            }
            set.add(x);
          }
          return false;
        }

        public boolean isSubarrayWithGivenSumPresent(int[] arr, int sum){
          int prefix_sum = 0;
          HashSet<Integer> set = new HashSet<>();
          for (int x : arr){
            prefix_sum += x;
            if(prefix_sum == sum){
              return true;
            }
            if(set.contains(prefix_sum - sum)){
              return true;
            }
            set.add(prefix_sum);
          }
          return false;
        }

    

    public static void main(String[] args) {}
}