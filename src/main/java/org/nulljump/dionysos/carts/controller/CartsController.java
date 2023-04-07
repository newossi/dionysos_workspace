package org.nulljump.dionysos.carts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.nulljump.dionysos.carts.model.service.CartsService;
import org.nulljump.dionysos.carts.model.vo.Carts;
import org.nulljump.dionysos.users.model.vo.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartsController {
	private static final Logger logger = LoggerFactory.getLogger(CartsController.class);

	@Autowired
	private CartsService cartsService;

	
	 //��ٱ��� ������ �̵�
    @RequestMapping("clistView.do")
    public String moveReviewDetailView() {
    	return "carts/cartsListView";
    }
    
    // ��ٱ��� �������� �̵��ϱ�
 //   @RequestMapping(value="clist.do" , method={ RequestMethod.GET , RequestMethod.POST })
//    public String movecartsListPage(@RequestParam("cart_id") int cart_id, HttpSession session,
 //                                  @RequestParam("cart_quantity") int number, Model model) {

        // 1. �α��ε� ��������� üũ : ���� ���ǿ� ����� ����� ������ ������
//        Users loginUser = (Users) session.getAttribute("loginUser");

        // 2. �α��εǾ� ���� ���� ���, �α��� �������� �̵�
//        if (loginUser == null) {

//            return "redirect:/users/loginPage.do";
//        }

    // 3. �α��ε� ������� ��ٱ��� ����� �������� : ������� �̸��Ϸ� ��ٱ��� ����� ������
//        ArrayList<Carts> cartsList = cartsService.getcartsList(loginUser.getEmail());

        // 4. ��ٱ��Ͽ� ��ǰ�� �ִ��� üũ
 //       if (cartsList != null && !cartsList.isEmpty()) {
            // 5. ��ǰ�� �����ϸ� �𵨿� �߰��ϰ� ��ٱ��� ������ ��ȯ
 //           model.addAttribute("cartsList", cartsList);
 //           return "carts/cartsListView";
//        } else {
            // 6. ��ǰ�� ������ ���� �޽����� ǥ���ϰ� Ȩ�������� �����̷�Ʈ
//            model.addAttribute("message", "��ٱ��Ͽ� ��ǰ�� �������� �ʽ��ϴ�!");
 //           return "redirect:/";
//        }
//    }

    
	 
    @RequestMapping("carts.do")
    public ModelAndView list(HttpSession session, ModelAndView mav) {
        Map<String, Object> map=new HashMap<>();
 
//hashmap�� map(key,value)�� �̷��� �ְ�,
//key���� �ߺ��� �Ұ��� �ϰ� value�� �ߺ��� �����ϴ�.
//value�� null���� ����� �����ϴ�.
 //������ ������ ���� ��쿡�� HashMap<>�� ����ϴ� ���� ����.
 //��ٱ��Ͽ� ���� ������ ���� ������ ���⼱ HashMap<>�� ����Ѵ�.
 
 
        String user_id=(String)session.getAttribute("user_id");
 
//session�� ����� userid�� getAttribute()�޼ҵ带 ����ؼ� ������ ������Ʈ Ÿ���̱� ������
//String Ÿ������ Ÿ�Ժ�ȯ�Ѵ�.
 
        if(user_id != null) { 
 //�α����� �����̸� ����
            ArrayList<Carts> list=cartsService.listCarts(user_id);//��ٱ��� ���
//            int sumMoney=cartsService.sumMoney(user_id);//�ݾ� �հ�
            
 
 //hasp map�� ��ٱ��Ͽ� ���� ���� ������ ������
 //           map.put("sumMoney", sumMoney);
            map.put("list", list); //��ٱ��� ���
            map.put("count", list.size()); //���ڵ� ����
 
 //ModelAndView mav�� �̵��� �������� �̸��� �����͸� �����Ѵ�.
 
            mav.setViewName("carts/cartsDetailView"); //�̵��� �������� �̸�
            mav.addObject("map", map); //������ ����
 
            return mav; //ȭ�� �̵�
 
        }else { //�α������� ���� ����
 
            return new ModelAndView("member/login", "", null);
//�α����� ���� �ʾ����� �α��� �������� �̵���Ų��.
        }
    }

	@RequestMapping("cartsInsert.do") //�������� url mapping
	 
    public String insertCarts(@ModelAttribute Carts carts, 
            HttpSession session) {
 
        //@ModelAttribute�� sumit�� form�� ������ �����ؼ� ���޹ްų�, �ٽ� ��� �Ѱܼ� ����ϱ� ���� ���Ǵ� ������Ʈ �̴�.
 
        //������ ������Ʈ�� DTO�� ������Ƽ�� ��û �Ķ���͸� ���ε��ؼ� �ѹ��� ������ @ModelAttribute ��� �� �� �ִ�.
 
        //@ModelAttribute�� ��Ʈ�ѷ��� �����ϴ� �𵨿� �Ķ���ͷ� ������ ������Ʈ�� �ڵ����� �߰����ش�.
        
        
        //�α��� ���θ� üũ�ϱ� ���� ���ǿ� ����� ���̵� Ȯ��
 
        String user_id=(String)session.getAttribute("user_id");
        if(user_id == null) { 
 
 //�α������� ���� �����̸� �α��� ȭ������ �̵�
 
            return "redirect:/member/login.do";
        }
//        User.setUserId(user_id);
        cartsService.insertCarts(carts); //��ٱ��� ���̺� �����
        return "redirect:carts.do"; //��ٱ��� ������� �̵�
    }


	@PostMapping("updateCarts.do")
	public String updateCart(@ModelAttribute("carts") Carts carts, String userId) {
		cartsService.updateCarts(carts);
		return "redirect:carts.do";
	}

	@RequestMapping("deleteCarts.do")
    public String deleteCarts(@RequestParam int cart_id) {
        cartsService.deleteCarts(cart_id);
        return "redirect:carts.do";
    }
	
	@RequestMapping("deleteAllCarts.do")
    public String deleteAllCarts(HttpSession session) {
        String user_id=(String)session.getAttribute("user_id");
        if(user_id != null) {
            cartsService.deleteAllCarts(user_id);
        }
        return "redirect:carts.do";
    }

}