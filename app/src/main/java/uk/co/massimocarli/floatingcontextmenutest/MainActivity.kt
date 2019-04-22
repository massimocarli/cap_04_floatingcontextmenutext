package uk.co.massimocarli.floatingcontextmenutest

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  /*
   * The Tag for the Log
   */
  private val TAG_LOG = "MainActivity"

  /*
   * The tag for the ListFragment
   */
  private val LIST_TAG = "LIST_FRAG"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // We add the Fragment
    if (savedInstanceState == null) {
      val frag = MyListFragment()
      supportFragmentManager.beginTransaction().add(R.id.container, frag, LIST_TAG).commit()
    }
  }

  override fun onContextItemSelected(item: MenuItem): Boolean {
    Log.i(TAG_LOG, "In Activity selected item: ${item.title}")
    // return true;
    return super.onContextItemSelected(item)
  }
}
