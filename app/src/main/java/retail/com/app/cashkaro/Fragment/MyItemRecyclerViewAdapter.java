package retail.com.app.cashkaro.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retail.com.app.cashkaro.Fragment.dummy.OfferContent.OfferItem;
import retail.com.app.cashkaro.R;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<OfferItem> mValues;
    private final HomeFragment.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<OfferItem> items, HomeFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offers_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mLogoImageView.setImageResource(holder.mItem.imageId);
        holder.mOfferView.setText(holder.mItem.offerText);
        holder.mMoreContentView.setText(holder.mItem.moreOffers);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mOfferView;
        public final TextView mMoreContentView;
        public final ImageView mLogoImageView;
        public OfferItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mOfferView = (TextView) view.findViewById(R.id.offerNameTextView);
            mMoreContentView = (TextView) view.findViewById(R.id.availableOffersTextView);
            mLogoImageView = (ImageView) view.findViewById(R.id.logo_imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMoreContentView.getText() + "'";
        }
    }
}
