package demo.ftmk.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.ftmk.product.Product;

/**
 * Servlet implementation class OrderRedirectServlet
 */
@WebServlet("/demo/orderRedirectServlet")
public class OrderRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get orderedProducts from session and cast to List of OrderedProduct
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				List<OrderedProduct> orderedProducts = (List<OrderedProduct>) session.getAttribute("orderedProducts");
				
				// Validate List - instantiate new List if List is null
				if (orderedProducts == null) {
					orderedProducts = new ArrayList<OrderedProduct>();
				}
				
				// Get data from web form
				String selectedProduct = request.getParameter("product");
				String specifiedQuantity = request.getParameter("quantity");
				
				int productId = Integer.parseInt(selectedProduct);
				int quantity = Integer.parseInt(specifiedQuantity);
				
				// Wrap data into object of OrderedProduct
				Product product = new Product();
				product.setProductId(productId);
				
				OrderedProduct orderedProduct = new OrderedProduct();
				orderedProduct.setOrderedProduct(product);
				orderedProduct.setQuantity(quantity);
				
				// Add object of OrderedProduct into List
				orderedProducts.add(orderedProduct);
				
				// Add List to session
				session.setAttribute("orderedProducts", orderedProducts);
				
				// Redirect to the same page
				response.sendRedirect("orderRedirectForm.html");

	}

}
