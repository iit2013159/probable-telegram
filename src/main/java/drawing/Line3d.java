/*
package drawing;

import jdk.internal.net.http.common.Pair;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;

public class Line3d implements GLEventListener{
    private GLU glu = new GLU();
    static Random random = new Random(System.currentTimeMillis());
    static long getRand(){
        return random.nextLong()%1000;
    }
    private Pair<Point3D,Point3D> getLine(float a,float b, float c, float d){
        Set<float []> r = range(1,1000000000).parallel().mapToObj(al -> check(a,b,c,d)).sorted().collect(Collectors.toSet());
        r.size();
        if(r.size() > 2){

            Iterator<float []> it = r.iterator();
            float[] ab = it.next();
             double v = ab[0];
             Point3D sd = new Point3D(ab[0],ab[1],ab[2]);
            return new Pair<Point3D,Point3D>(sd,sd);
        }
        return null;
    }
    private static float[] check(float a, float b, float c, float d) {
        float x = getRand();
        float y = getRand();
        float z = getRand();
        boolean re = (a*x +b*y +c*z + d) == 0;
        if (re == true){
            System.out.println("a "+a +" b "+b +" c "+c +" x "+x +" y "+y +" z "+z );
            return new float[]{x,y,z};
        }
        return null;
    }
    @Override
    public void display( GLAutoDrawable drawable ) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glTranslatef( 0f, 0f, -2.5f );
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.75f,0f,0 );
        gl.glVertex3f( 0f,-0.75f, 0 );
        gl.glEnd();
        //3d line
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.75f,0f,3f );// 3 units into the window
        gl.glVertex3f( 0f,-0.75f,3f );
        gl.glEnd();
    }
    @Override
    public void dispose( GLAutoDrawable arg0 ) {
        //method body
    }
    @Override
    public void init( GLAutoDrawable arg0 ) {
        // method body
    }
    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
        GL2 gl = drawable.getGL().getGL2();
        if( height <=0 )
            height =1;
        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();
        glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }
    public static void main( String[] args ) {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );
        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Line3d line3d = new Line3d();

        glcanvas.addGLEventListener( line3d );
        glcanvas.setSize( Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height );
        //creating frame
        final JFrame frame = new JFrame (" 3d line");
        //adding canvas to it
        frame.getContentPane().add( glcanvas );
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
    }//end of main
}//end of class
*/
