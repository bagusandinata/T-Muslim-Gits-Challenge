package bagusandinata.t_muslim.Model;

public class Schedule {
    public String mLocation;
    public String mSubuh;
    public String mDhuhur;
    public String mAshar;
    public String mMaghrib;
    public String mIsya;

    public Schedule(String mLocation, String mSubuh, String mDhuhur, String mAshar, String mMaghrib, String mIsya) {
        this.mLocation = mLocation;
        this.mSubuh = mSubuh;
        this.mDhuhur = mDhuhur;
        this.mAshar = mAshar;
        this.mMaghrib = mMaghrib;
        this.mIsya = mIsya;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmSubuh() {
        return mSubuh;
    }

    public String getmDhuhur() {
        return mDhuhur;
    }

    public String getmAshar() {
        return mAshar;
    }

    public String getmMaghrib() {
        return mMaghrib;
    }

    public String getmIsya() {
        return mIsya;
    }
}
