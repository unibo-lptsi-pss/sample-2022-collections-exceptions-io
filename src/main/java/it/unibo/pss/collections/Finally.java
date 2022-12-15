package it.unibo.pss.collections;

class Finally {
    
    static int m() {
        try {
            return 1;
        } finally {
            System.out.println("FINALLY");
        }
    }

    public static void main(String[] args) {
        m();
    }
}