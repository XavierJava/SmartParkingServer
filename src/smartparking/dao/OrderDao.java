package smartparking.dao;

import smartparking.model.Order;

import java.util.List;

/**
 * 订单表的数据库访问接口
 */
public interface OrderDao {
    /**
     * 数据库中的所有订单
     *
     * @param offset 结果集行偏移量
     * @param limit  结果集最大行数
     * @return 包含limit个Order对象的List
     */
    List<Order> getOrders(long offset, long limit);

    /**
     * 根据订单号对应的订单信息
     * @param OrderId 订单号
     * @return 订单对象
     */
    Order getOrderById(int OrderId);

    /**
     * 某一用户在某一停车场的所有订单
     * @param userId 用户编号
     * @param parkingLotId 停车场编号
     * @param offset 结果集行偏移量
     * @param limit 结果集的最大行数
     * @return 包含limit个order对象的list
     */
    List<Order> getOrderByUserIdAndParkingLotId(int userId, int parkingLotId, long offset, long limit);

    /**
     * 某一用户的所有订单
     * @param userId 用户编号
     * @param offset 结果集偏移量
     * @param limit 结果集最大行数
     * @return 包含limit个order对象的list
     */
    List<Order> getOrdersByUserId(int userId, long offset, long limit);

    /**
     * 某停车场的所有订单
     * @param parkingLotId 停车场的编号
     * @param offset 结果集偏移量
     * @param limit 结果集最大行数
     * @return 包含limit个order对象的list
     */
    List<Order> getOrdersByParkingLotId(int parkingLotId, long offset, long limit);

    /**
     * 新建订单
     * @param order 将要新建订单的实例
     * @return 新建订单成功后, 数据库分配给新订单的编号
     */
    int addOrder(Order order);

    /**
     * 更新订单
     * @param order 新的订单实例,该实例有原来的编号
     * @return 更新成功, 返回1, 失败则0
     */
    int updateOrder(Order order);

    /**
     * 删除订单
     * @param id 订单编号
     * @return 删除成功, 返回1, 失败则0
     */
    int removeOrderById(int id);
}
