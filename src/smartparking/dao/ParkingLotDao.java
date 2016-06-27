package smartparking.dao;

import smartparking.model.ParkingLot;

import java.util.List;

/**
 * 停车场表的数据库访问接口
 */
public interface ParkingLotDao {
    /**
     * 根据编号获取停车场对象
     *
     * @param id 停车场编号
     * @return 停车场对象
     */
    ParkingLot getParkingLotById(int id);

    /**
     *根据名字获取停车场对象
     * @param name 停车场编号
     * @return 停车场对象
     */
    ParkingLot getParkingLotByName(String name);

    /**
     * 获取所有停车场信息
     * @param offset 结果集偏移量
     * @param limit 结果集最大个数
     * @return 包含limit个停车场对象的list
     */
    List<ParkingLot> getParkingLots(long offset, long limit);

    /**
     * 获取指定坐标附近的停车场
     * @param longitude 经度
     * @param latitude 纬度
     * @param kilometers 半径
     * @return 符合要求的停车场对象list
     */
    List<ParkingLot> getNearParkingLots(double longitude, double latitude, int kilometers);

    /**
     * 新建停车场
     * @param parkLot 将要新建的停车场对象
     * @return 数据库分配给新建对象的编号
     */
    int addParkingLot(ParkingLot parkLot);

    /**
     * 更新停车场
     * @param parkingLot 含有新信息的停车场对象,有原来的编号
     * @return 更新成功则1, 失败则0
     */
    int updateParkingLot(ParkingLot parkingLot);

    /**
     * 删除停车场
     * @param id 停车场的编号
     * @return 删除成功则1, 失败则0
     */
    int removeParkingLotById(int id);

}
