package com.physics.quesbank.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

/**
 * @ClassName ExceptionHandler
 * @Description TODO
 * @Author aron
 * @Date 2019/8/2 11:19
 **/
public class ExceptionHandler {

    public static void printException(Logger logger, Exception e) {
        synchronized (new WrappedPrintStream(System.err).lock()) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            logger.info(e.toString());
            for (StackTraceElement st : stackTraceElements) {
                logger.info(st.toString());
            }
        }
    }

    private static class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        Object lock() {
            return printStream;
        }

        void println(Object o) {
            printStream.println(o);
        }
    }

    private abstract static class PrintStreamOrWriter {
        /** Returns the object to be locked when using this StreamOrWriter */
        abstract Object lock();

        /** Prints the specified string as a line on this StreamOrWriter */
        abstract void println(Object o);
    }

}
