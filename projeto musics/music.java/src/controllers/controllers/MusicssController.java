
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import models.Musicss;
import repository.MusicssRepository;
import views.Music;
import views.MusicssTableView;

public class MusicssController {
    private MusicssRepository repository;
    private MusicssTableView tableView;

    public MusicssController() {
        repository = new MusicssRepository();
        tableView = new MusicssTableView();
        inicializar();
    }
    private void inicializar() {
        //Atualizar a tabela com os Musics existentes
        atualizarTabela();

        //Criar a barra de ferramenta (toolbar) com botões
        JToolBar toolBar = new JToolBar();
        JButton adicionarButton = new JButton("Adicionar");
        JButton editarButton = new JButton("Editar");
        JButton deletarButton = new JButton("Deletar");
        toolBar.add(adicionarButton);
        toolBar.add(editarButton);
        toolBar.add(deletarButton);
        
        tableView.add(toolBar, java.awt.BorderLayout.NORTH);

        // Ações dos botões
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMusic();
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarMusic();
            }
        });
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarMusic();
            }
        });

        tableView.setVisible(true);
    }
private void atualizarTabela() {
        List<Musicss> Musics = repository.obterTodosMusicsss();
        tableView.atualizarTabela(Musics);
    }
    
    private void adicionarMusic() {
        Music form = new Music(tableView, "Adicionar Music", null);
        form.setVisible(true);
        Musicss novoMusic = form.getmusicss();
        if (novoMusic != null) {
            repository.adicionarMusicss(novoMusic);
            atualizarTabela();
        }
    }
private void editarMusic() {
        int selectedId = tableView.getSelectedmusicssId();
        if (selectedId != -1) {
            Musicss Music = repository.obterMusicssPorId(selectedId);
            if (Music != null) {
                Music form = new Music(tableView,
                    "Editar Music", Music);
                form.setVisible(true);
                Musicss MusicAtualizado = form.getmusicss();
                if (MusicAtualizado != null) {
                    MusicAtualizado = new Musicss(
                        selectedId,
                        MusicAtualizado.getNome(),
                        MusicAtualizado.getidade(),
                        MusicAtualizado.getMusicas(),
                        MusicAtualizado.getGrammys(),
                        MusicAtualizado.getVivo(),
                        MusicAtualizado.getGenero(),
                        MusicAtualizado.getNacionalidade()
                    );
                    repository.AtualizarMusicss(MusicAtualizado);
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(tableView,
                    "Music não encontrado.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(tableView,
                "Selecione um Music para editar.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
private void deletarMusic() {
    int selectedId = tableView.getSelectedmusicssId();
    if (selectedId != -1) {
        int confirm = JOptionPane.showConfirmDialog(
            tableView,
            "Tem certeza que deseja deletar esse Music?",
            "Confirmar Deleção",
            JOptionPane.YES_NO_OPTION) ;
        if (confirm == JOptionPane.YES_OPTION) {
            repository.deletarMusicss(selectedId);
            atualizarTabela();
        }
    } else {
        JOptionPane.showMessageDialog(
            tableView,
            "Selecione um Music para deletar.",
            "Aviso",
            JOptionPane.WARNING_MESSAGE);
    
        }
    }
    
    public void iniciar() {
        //Ações já são inicializadas no construtor
    }
}