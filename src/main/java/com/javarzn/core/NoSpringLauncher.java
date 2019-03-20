package com.javarzn.core;

import com.javarzn.core.nospring.processing.TaskManager;

/**
 * Точка входа в приложение, тут поднимается контекст спринга.
 *
 * @author Konstantin
 */
public class NoSpringLauncher {
    public static void main(String[] args) {
        new TaskManager();
    }
}
