/*
 * This file is part of the application library that simplifies common
 * initialization and helps setting up any java program.
 * 
 * Copyright (C) 2016 Yannick Drost, all rights reserved.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.drost.application.plaf.rich;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

import javax.swing.Painter;

/**
 * This extends the {@code AbstractPainter<T>} class and implements the
 * {@code paint}-method of the {@link Painter<T>} interface.
 * <p>
 * It is used by the {@link RichLookAndFeel} to render all necessary UI
 * components. This class is responsible for painting the associated component
 * having the same name in the defaults table, accessible by
 * {@code UIManager#getDefaults()}.
 * 
 * @author Yannick Drost
 * 
 * @see AbstractPainter
 * @see Painter
 *
 */
final class RichTextAreaBackgroundPainter extends AbstractPainter<Component>
{
	boolean enabled;
	
	RichTextAreaBackgroundPainter(boolean enabled)
	{
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Painter#paint(java.awt.Graphics2D, java.lang.Object, int, int)
	 */
	@Override
	public void paint( Graphics2D g, Component object, int width, int height )
	{
		if(enabled)
		{
			g.setColor( theme.getBackgroundDarker( ) );
			g.fillRect( 0, 0, width, height );

			g.setColor( theme.getShadowDark( ) );
			g.drawLine( 0, 0, width, 0 );
			
			g.setColor( theme.getShadowLight( ) );
			g.drawLine( 0, 1, width, 1 );
		}
		else
		{
			g.setColor( theme.getBackgroundBrighter( ) );
			g.fillRect( 0, 0, width, height );
			
			g.setColor( theme.getShadowDark( ) );
			g.drawLine( 0, 0, width, 0 );
			
			g.setColor( theme.getShadowLight( ) );
			g.drawLine( 0, 1, width, 1 );
		}
	}

}
