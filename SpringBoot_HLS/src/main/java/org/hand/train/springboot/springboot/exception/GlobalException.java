package org.hand.train.springboot.springboot.exception;

/**
 * NameException
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant
 * @date 10:02 2019/12/4
 */
public class GlobalException extends IllegalArgumentException {
    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
    }
}
