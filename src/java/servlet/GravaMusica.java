
package servlet;

import classes.Musica;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
    location="/", 
    fileSizeThreshold=1024*1024,    // 1MB *      
    maxFileSize=1024*1024*100,      // 100MB **
    maxRequestSize=1024*1024*10*10  // 100MB *
)

@WebServlet(name = "GravaMusica", urlPatterns = {"/GravaMusica"})
public class GravaMusica extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensagem = "Musica inserida com sucesso";
        try
        {
            String nomeM = request.getParameter("nome");
            String nomeC = request.getParameter("cantor");
            String tp = request.getParameter("tpmusic");
            Musica nova = new Musica(nomeM,nomeC,tp);
            Part musica = request.getPart("musica");
            byte[] arq=new byte[(int)musica.getSize()];
            musica.getInputStream().read(arq);
            FileOutputStream arquivo = new FileOutputStream(new File(getServletContext().getRealPath("/") + "/" + nova.getNome()+".mp3"));
            arquivo.write(arq);
            arquivo.close();
        }catch(Exception e){mensagem="Erro ao armazenar os dados";}
        try (PrintWriter out = response.getWriter()) {
            out.print(mensagem);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
