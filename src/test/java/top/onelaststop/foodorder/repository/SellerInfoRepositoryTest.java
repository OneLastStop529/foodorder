package top.onelaststop.foodorder.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.onelaststop.foodorder.dataobject.SellerInfo;
import top.onelaststop.foodorder.util.KeyUtil;


@RunWith(SpringRunner.class)
@SpringBootTest

public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;


    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc123");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setSellerid(KeyUtil.genUniqueKey());
        SellerInfo save = sellerInfoRepository.save(sellerInfo);


        Assert.assertNotNull(save);

    }

    @Test
    public void findByOpenid() throws Exception{
        SellerInfo result = sellerInfoRepository.findByOpenid("abc123");

        Assert.assertEquals("abc",result.getOpenid());
    }

}