package booboo.thelocalnick.CreateTour

import android.support.v7.widget.RecyclerView
import android.view.View
import booboo.thelocalnick.data.Spot
import booboo.thelocalnick.data.Tour
import java.util.ArrayList

class CreateTourViewModel {
    var spotFragment: SpotFragment? = null
    var tourTimeCostFragment: TourTimeCostFragment? = null
    var tourPhotosFragment: TourPhotosFragment? = null
    var recyclerView: RecyclerView? = null
    var tour: Tour? = null
    var spots: List<Spot>? = ArrayList()

    init {
        tourTimeCostFragment = TourTimeCostFragment()
        tourTimeCostFragment?.ctvm = this
        tourPhotosFragment = TourPhotosFragment()
        tourPhotosFragment?.ctvm = this
    }

    fun onAddSpotClicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            spotFragment?.showAddSpotDialog()
        }
    }

    fun onNextClickedSpotDescription(): View.OnClickListener {
        return View.OnClickListener { view ->
            //TODO validation to be done
            spots = spotFragment?.list
            tour = Tour(spots)
            //tourTimeCostFragment?.show(spotFragment?.activity?.fragmentManager)
        }
    }

    fun onNextClickedTourTimeCost(): View.OnClickListener {
        return View.OnClickListener { view ->
            //TODO validation to be done
            tour?.cost = tourTimeCostFragment?.binding?.tourCost?.text.toString() as Float
            tour?.time = tourTimeCostFragment?.binding?.tourTime?.text.toString() as Float
            //tourPhotosFragment?.show(spotFragment?.activity?.fragmentManager)
        }
    }

    fun onAddPhotosClicked(): View.OnClickListener {
        return View.OnClickListener { view ->

        }
    }
}