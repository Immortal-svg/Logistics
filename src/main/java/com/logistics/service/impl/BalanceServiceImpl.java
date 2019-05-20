package com.logistics.service.impl;

        import com.baomidou.mybatisplus.plugins.Page;
        import com.baomidou.mybatisplus.service.impl.ServiceImpl;
        import com.logistics.entity.Balance;
        import com.logistics.mapper.BalanceMapper;
        import com.logistics.service.BalanceService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author q
 * @since 2019-05-04
 */
@Service
public class BalanceServiceImpl extends ServiceImpl<BalanceMapper, Balance> implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;
  //通过customerID查询
    @Override
    public Page<Balance> page(int pageNo, int pageSize, Balance balance) {
        Page<Balance> page=new Page<Balance>(pageNo,pageSize);
        return  page.setRecords(this.balanceMapper.page(page,balance));
    }
  //多添建查询
    @Override
    public Page<Balance> selectfinance(int pageNo, int pageSize, Balance balance, String customerName, String paidTime1, String paidTime2) {
        Page<Balance> page=new Page<Balance>(pageNo,pageSize);
        return page.setRecords(this.balanceMapper.selectfinance(page,balance,customerName,paidTime1,paidTime2));
    }

    @Override
    public Page<Balance> selectcountall(int pageNo, int pageSize, String paidTime, String oprTime) {
        Page<Balance> page=new Page<Balance>(pageNo,pageSize);
        return page.setRecords(this.balanceMapper.selectcountall(page,paidTime,oprTime));
    }
}
