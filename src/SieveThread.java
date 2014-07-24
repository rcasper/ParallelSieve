/**
 * This is the worker thread for the program, the SieveThread. The SieveThread
 * is given a name, the address of the Boolean array representing the number
 * range, and the prime number it is supposed to be eliminating multiples of,
 * which it does by iterating through the list and checking each index value
 * using modular division, writing true to represent a non-prime where appropriate.
 * @author Ryan Kasprzyk
 */
public class SieveThread extends Thread {
private final boolean[] list;
int pr;

/**
 * 
 * @param name Thread name
 * @param block Number range array
 * @param prime Prime to check values against
 */
    public SieveThread(String name, boolean[] block, int prime) {
        super(name);
        list = block;
        pr = prime;
    }
    @Override
    public void run() {
        int mod;
        for(int i = pr+1; i < list.length; i++){
            if((i % pr) == 0){
                list[i] = true;
            }
        }
    }
}
