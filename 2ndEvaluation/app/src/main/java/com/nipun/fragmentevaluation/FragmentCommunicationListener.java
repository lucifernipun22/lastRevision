package com.nipun.fragmentevaluation;

import android.os.Bundle;

public interface FragmentCommunicationListener {
   void onDataReceived(Bundle bundle);
   void onDataReceivedTwo(Bundle bundle);
   void onDataReceivedThree(Bundle bundle);
}