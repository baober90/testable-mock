package com.alibaba.testable.agent.handler;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;

/**
 * @author flin
 */
abstract public class ClassHandler implements Opcodes {

    public byte[] getBytes(String className) throws IOException {
        ClassReader cr = new ClassReader(className);
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        transform(cn);
        ClassWriter cw = new ClassWriter( 0);
        cn.accept(cw);
        return cw.toByteArray();
    }

    abstract protected void transform(ClassNode cn);

}
