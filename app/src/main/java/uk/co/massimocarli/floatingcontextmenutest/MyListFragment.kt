package uk.co.massimocarli.floatingcontextmenutest

import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment

class MyListFragment : ListFragment() {
  /*
   * The Tag for the Log
   */
  private val TAG_LOG = "MyListFragment"

  /*
   * The size of our model
   */
  private val ARRAY_SIZE = 100

  /*
   * Out model for test
   */
  private lateinit var mModel: Array<String>

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    // Create the model
    mModel = Array<String>(ARRAY_SIZE) {
      "Item $it"
    }
    // We create the Adpater
    listAdapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, mModel)
    // We register the contextual menu
    registerForContextMenu(listView)
  }

  override fun onCreateContextMenu(
    menu: ContextMenu,
    v: View,
    menuInfo: ContextMenu.ContextMenuInfo
  ) {
    val menuInflater = MenuInflater(activity)
    menuInflater.inflate(R.menu.menu_main, menu)
    Log.i(TAG_LOG, "In Fragment onCreateContextMenu ")
    super.onCreateContextMenu(menu, v, menuInfo)
  }

  override fun onContextItemSelected(item: MenuItem): Boolean {
    Log.i(TAG_LOG, "In Fragment selected item: ${item.title}")
    return super.onContextItemSelected(item)
  }
}