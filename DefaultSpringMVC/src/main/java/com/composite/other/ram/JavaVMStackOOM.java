package com.composite.other.ram;

/**
 * 虚拟机和本地方法栈溢出
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {
    private void running() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> running()).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }


}
