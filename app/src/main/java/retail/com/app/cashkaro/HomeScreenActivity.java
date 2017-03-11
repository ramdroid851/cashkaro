package retail.com.app.cashkaro;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import retail.com.app.cashkaro.Fragment.HomeFragment;
import retail.com.app.cashkaro.Fragment.dummy.OfferContent;

public class HomeScreenActivity extends AppCompatActivity implements HomeFragment.OnListFragmentInteractionListener {

    @BindView(R.id.offers_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.view_pager_indicator)
    CirclePageIndicator mCirclePageIndicator;

    CustomPagerAdapter mCustomPagerAdapter;
    private int mResources[] = {R.drawable.sports, R.drawable.air_offers, R.drawable.jabong_offer, R.drawable.oyo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().add(R.id.frg_container, HomeFragment.newInstance()).commit();
        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager.setAdapter(mCustomPagerAdapter);
        mCirclePageIndicator.setViewPager(mViewPager);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.home_menu, menu);
//        return true;
//    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public void onListFragmentInteraction(OfferContent.OfferItem item, int position) {
        String uri = null;
        switch (position % 4) {
            case 1:
            case 3:
                uri = "http://www.amazon.in/b/ref=desktop_hssbunk_GW_march17?ie=UTF8&node=10892568031&tag=cashkacom-21&ascsubtag=CHKR17384100";
                break;
            case 0:
            case 2:
                uri = "https://www.flipkart.com/home-kitchen/home-appliances/air-conditioners/split~type/pr?otracker=categorytree&p%5B%5D=facets.capacity%255B%255D%3D1%2BTon&p%5B%5D=facets.capacity%255B%255D%3D1.2%2BTon&p%5B%5D=facets.capacity%255B%255D%3D1.5%2BTon&p%5B%5D=facets.energy_rating%255B%255D%3D3%2BStar&p%5B%5D=facets.energy_rating%255B%255D%3D5%2BStar&p%5B%5D=facets.energy_rating%255B%255D%3DInverter%2B%25283%2BStar%2529&p%5B%5D=facets.energy_rating%255B%255D%3DInverter%2B%25285%252B%2BStar%2529&p%5B%5D=facets.fulfilled_by%255B%255D%3DFlipkart%2BAssured&p%5B%5D=facets.offer_type%255B%255D%3DSpecial%2BPrice&p%5B%5D=facets.type%255B%255D%3DSplit&sid=j9e%2Fabm%2Fc54&otracker=hp_banner_widget_0&otracker=hp_banner_widget_0";
                break;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(browserIntent);
    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.offers_image, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.offerImageView);
            imageView.setImageResource(mResources[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( "http://www.amazon.in/b/ref=desktop_hssbunk_GW_march17?ie=UTF8&node=10892568031&tag=cashkacom-21&ascsubtag=CHKR17384100"));
                    startActivity(browserIntent);
                }
            });

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
