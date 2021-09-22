package com.chomolungma.system.org.domain.service;//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼           BUG辟易
//
//                             佛曰:
//
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

import com.chomolungma.system.infrastructure.DomainService;
import com.chomolungma.system.infrastructure.SpringBeanUtils;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;

/**
 * @author: kushu001
 * @date: 2021-08-04 17:36
 */
public class SaveDomainService implements DomainService<Void> {

    private OrgEntity orgEntity;

    public SaveDomainService(OrgEntity orgEntity){
        this.orgEntity = orgEntity;
    }


    @Override
    public Void execute() {
        SpringBeanUtils.getBean(OrgMapper.class).insert(orgEntity);
        return null;
    }

    @Override
    public boolean check() {
        System.out.println("检测失败");
        return false;
    }
}
