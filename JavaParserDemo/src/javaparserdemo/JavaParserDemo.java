/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparserdemo;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.TypeParameter;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thomas
 */
public class JavaParserDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        
        // creates an input stream for the file to be parsed
        try
        {
        FileInputStream in = new FileInputStream("A.java");

        CompilationUnit cu;
            // parse the file
            cu = JavaParser.parse(in);
            in.close();

        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
        
        // visit and print the methods names
        new MethodVisitor().visit(cu, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaParserDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JavaParserDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JavaParserDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    /**
    * Simple visitor implementation for visiting MethodDeclaration nodes. 
    */
    private static class MethodVisitor extends VoidVisitorAdapter 
    {

       @Override
       public void visit(MethodDeclaration n, Object arg) {
           super.visit(n, arg); //Ceci permet de parcourir les enfants
           // here you can access the attributes of the method.
           // this method will be called for all methods in this 
           // CompilationUnit, including inner class methods
           System.out.println(n.getName());
       }
       
       @Override
       public void visit(ClassOrInterfaceDeclaration coid, Object arg) {
           super.visit(coid, arg); //Ceci permet de parcourir les enfants
           // here you can access the attributes of the method.
           // this method will be called for all methods in this 
           // CompilationUnit, including inner class methods
           System.out.println(coid.getName());
       }
       
       @Override
       public void visit(Parameter prmtr, Object arg) {
           super.visit(prmtr, arg); //Ceci permet de parcourir les enfants
           // here you can access the attributes of the method.
           // this method will be called for all methods in this 
           // CompilationUnit, including inner class methods
           System.out.println(prmtr.getType());
       }
    }
}
