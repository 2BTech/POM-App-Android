package com.twobtech.pomapp.Models;

import java.util.ArrayList;
import java.util.List;

public class GasModel {

    public List<BLEPacket> packets = new ArrayList<BLEPacket>();
    String name = "";
    String units = "";
    public double max = 0.0;
    public double min = 9990.0;

    public DeviceModel deviceParent = null;

    public void addpacket(BLEPacket packet)
    {
        packets.add(packet);
        packet.gasParent = this;

        max = Math.max(max, packet.value);
        min = Math.min(min, packet.value);
    }

    public GasModel()
    {

    }


}
