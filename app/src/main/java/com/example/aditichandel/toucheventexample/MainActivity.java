    package com.example.aditichandel.toucheventexample;

    import android.os.Bundle;
    import android.support.v4.view.MotionEventCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.MotionEvent;
    import android.widget.TextView;

    import static java.lang.Math.sqrt;

    public class MainActivity extends AppCompatActivity {


        TextView textviewxy,textviewdistance;
        float x1=0,x2=0,y1=0,y2=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            initilizeTextView();
        }
        private void initilizeTextView()
        {
            textviewxy=(TextView)findViewById(R.id.textview_x_y);
            textviewdistance=(TextView)findViewById(R.id.textview_distance);
        }
        public boolean onTouchEvent(MotionEvent event)
        {
            int mActivePointerID;
            int action= MotionEventCompat.getActionMasked(event);
            mActivePointerID = event.getPointerId(0);
            int pointerindex = event.findPointerIndex(mActivePointerID);
            float x = event.getX(pointerindex);
            float y = event.getY(pointerindex);
            textviewxy.setText("X = "+x+" Y ="+y);
            Log.d("Displaying event ",event.toString());
            if(action==MotionEvent.ACTION_DOWN)
            {
                x1 = x;
                y1 = y;
                System.out.println("======X1 = "+x1+" Y1 =  "+y1);
            }
            else if(action==MotionEvent.ACTION_UP)
            {
                x2 = x;
                y2 = y;
                System.out.println("X1 = "+x2+" Y1 =  "+y2);
                double distance = sqrt(((x2-x1)*(x2-x1) +(y2-y1)*(y2-y1)));
                textviewdistance.setText(""+distance);
            }
            else if(action==MotionEvent.ACTION_MOVE)
            {
                System.out.println("==========Hello World");
            }

            return false;
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
