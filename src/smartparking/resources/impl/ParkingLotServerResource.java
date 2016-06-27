package smartparking.resources.impl;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.common.Settings;
import smartparking.dao.ParkingLotDao;
import smartparking.model.ParkingLot;
import smartparking.resources.ParkingLotResource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ParkingLotServerResource extends ServerResource implements ParkingLotResource {
    private ParkingLotDao parkingLotDao;
    private String idOrName;//停车场编号或名字
    private String q;//查询字段,指示是根据编号还是名字

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        parkingLotDao = Settings.getParkingLotDao();
        /**
         * 解码URL的中文参数
         */
        try {
            idOrName = URLDecoder.decode(getAttribute("idOrName"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        q = getQueryValue("q");
    }

    /**
     * 获取指定编号或名字的停车场
     *
     * @return 停车场对象
     */
    @Override
    public ParkingLot getParkingLot() {
        /**
         * 根据参数执行查询计划
         */
        if (q.equals("id"))
            return parkingLotDao.getParkingLotById(Integer.parseInt(idOrName));
        if (q.equals("name"))
            return parkingLotDao.getParkingLotByName(idOrName);
        else
            return null;

    }

    /**
     * 删除停车场
     * @return 执行结果, 成功1, 失败0
     */
    @Override
    public int removeParkingLot() {
        return parkingLotDao.removeParkingLotById(Integer.parseInt(idOrName));
    }
}
