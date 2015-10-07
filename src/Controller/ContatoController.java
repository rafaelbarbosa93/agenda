package Controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Bean.ContatoBean;
import DAO.ContatoDAO;

@ManagedBean(name="contatoController")
@SessionScoped
public class ContatoController implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private ContatoBean contatoB;
	private DataModel listaContato;
	
	public ContatoController(){
		contatoB = new ContatoBean();
	}

	public ContatoBean getContatoB() {
		return contatoB;
	}

	public void setContatoB(ContatoBean contatoB) {
		this.contatoB = contatoB;
	}

	public DataModel getListaContato() {
		ContatoDAO cd = new ContatoDAO();
		listaContato = new ListDataModel(cd.listarContato());
		return listaContato;
	}

	public void setListaContato(DataModel listaContato) {
		this.listaContato = listaContato;
	}
	
	public void novoContato(){
		contatoB = new ContatoBean();
	}
	
	public void selecionarContato(){
		contatoB = (ContatoBean)listaContato.getRowData();
	}
	public String salvarContato(){
		ContatoDAO cD = new ContatoDAO();
		if(cD.salvarContato(contatoB)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"CADASTRADO COM SUCESSO!",""));
			return "listarcontatos";
		}
		return "erro";
	}
	
	public String editarContato(){
		ContatoDAO cD = new ContatoDAO();
		if(cD.editarContato(contatoB)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"EDITADO COM SUCESSO!",""));
			return "listarcontatos";
		}
		return "error";
	}
	
	public String excluirContato(){
		ContatoDAO cD = new ContatoDAO();
		if(cD.excluirContato(contatoB)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"EXCLUIDO COM SUCESSO!",""));
			return "listarcontatos";
		}
		return "error";
	}
}
