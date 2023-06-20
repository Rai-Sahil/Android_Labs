import android.app.Fragment

class SlideshowFragmentAdapter(fragment: Fragment, private val images: List<Int>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return images.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = SlideshowImageFragment()
        val bundle = Bundle()
        bundle.putInt("imageResource", images[position])
        fragment.arguments = bundle
        return fragment
    }
}
